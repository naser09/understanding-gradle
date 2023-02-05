import myproject.tasks.GenerateStartScript
plugins {
//    id("my-base-library")
    id("application")
//    id("checkstyle")
//    id("org.jetbrains.kotlin.jvm")
}
dependencies {
//    implementation(project(":data-model"))
}
java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(11))
}
//checkstyle {
//    maxWarnings = 0
////    configFile = rootProject.file("config/checkstyle/checkstyle.xml")
//}
val myTaskGroup = "My Application Task Group"

tasks.named<TaskReportTask>("tasks"){
    displayGroup = myTaskGroup
}
tasks.build{
    group = myTaskGroup
}
tasks.named("run"){
    group = myTaskGroup
}
val generatedScript = tasks.register<GenerateStartScript>("generateStartScript"){
    scriptFile.set(layout.projectDirectory.file("run.sh"))
}
tasks.check {
    group = myTaskGroup
    description = "normal check"
}
val packaging = tasks.register<Zip>("packageMyApp"){
    group = myTaskGroup
    description = "package my app to zip file"
    from(generatedScript)
    from(tasks.jar){
        into("libs")
    }
    from(configurations.runtimeClasspath){
        into("libs")
    }
    destinationDirectory.set(layout.buildDirectory.dir("dist"))
    archiveFileName.set("myApp.zip")
}
tasks.build{
    dependsOn(packaging) //make actionable task to lifecycle task
}
//tasks.checkstyleMain{
//    outputs.cacheIf { true }
//    group = myTaskGroup
////    configDirectory.set(rootDir)
//}
tasks.check {
    group = myTaskGroup
}
tasks.register("qualityCheck"){
    group = myTaskGroup
    description = "my test quality check"
    dependsOn(tasks.classes)
    dependsOn(tasks.check)
}