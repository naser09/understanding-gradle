plugins {
    id("my-library-test")
}
application {
    mainClass.set("MyApplication2")
}
tasks.generateStartScript {
    mainClass.set("MyApplication2")
}
dependencies {
    implementation(project(":business-logic"))
}