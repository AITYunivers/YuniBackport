pluginManagement {
    repositories {
        maven("https://maven.fabricmc.net/")
        maven ("https://maven.glass-launcher.net/babric")
        mavenCentral()
        gradlePluginPortal()
    }
}

rootProject.name = "YuniBackport"

include(":yunibackport_lib")

include(":yunibackport_r0")