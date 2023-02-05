plugins {
    id("java")
}
java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(11))
}
tasks.test {
    useJUnitPlatform()
}
dependencies {
}
val myGroup = "my project task group"
tasks.named<TaskReportTask>("tasks"){
    displayGroup = myGroup
}
tasks.build {
    group = myGroup
}