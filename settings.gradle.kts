pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "NYTBooksApp"
include(":app")
include(":core:data")
include(":core:database")
include(":core:network")
include(":core:designsystem")
include(":core:domain")
include(":core:common")
include(":feature:home")
include(":feature:books")
include(":core:datastore")
include(":feature:splash")
include(":feature:favourite")
include(":feature:settings")
