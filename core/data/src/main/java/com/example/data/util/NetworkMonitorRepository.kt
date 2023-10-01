package com.example.data.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.ConnectivityManager.NetworkCallback
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest.Builder
import android.os.Build
import androidx.core.content.getSystemService
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.conflate
import javax.inject.Inject

class NetworkMonitorRepository @Inject constructor(
    @ApplicationContext val context: Context
) : NetworkMonitor {

    override val networkStatus: Flow<NetworkStatus> = callbackFlow {
        val networkManager = context.getSystemService<ConnectivityManager>()
        if (networkManager == null) {
            channel.trySend(NetworkStatus.Disconnected)
            channel.close()
        } else {

            channel.trySend(NetworkStatus.Disconnected)

            val callback = object : NetworkCallback() {
                override fun onAvailable(network: Network) {
                    channel.trySend(NetworkStatus.Connected)
                }

                override fun onUnavailable() {
                    channel.trySend(NetworkStatus.Disconnected)
                }

                override fun onLost(network: Network) {
                    channel.trySend(NetworkStatus.Disconnected)
                }
            }

            val request = Builder()
                .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
                .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
                .build()

            networkManager.registerNetworkCallback(request, callback)

            awaitClose {
                networkManager.unregisterNetworkCallback(callback)
            }
        }
    }.conflate()

}