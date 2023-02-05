rootProject.name = "my-project"

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
    }
    includeBuild("../my-build-logic")
}
dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}
rootDir.listFiles()?.filter { it.isDirectory && !it.isHidden }?.forEach {
    println(it.name)
    include(it.name)
}