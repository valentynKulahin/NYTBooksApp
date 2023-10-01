package com.example.database.di

import android.content.Context
import androidx.room.Room
import com.example.database.NYTDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesNYTDatabase(
        @ApplicationContext context: Context
    ): NYTDatabase = Room.databaseBuilder(
        context = context,
        klass = NYTDatabase::class.java,
        name = "nyt-database"
    ).build()

}