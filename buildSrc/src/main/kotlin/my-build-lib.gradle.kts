import gradle.kotlin.dsl.accessors._361507a1673cfabfb4f9240965fcfe53.checkstyle
import gradle.kotlin.dsl.accessors._361507a1673cfabfb4f9240965fcfe53.java
import gradle.kotlin.dsl.accessors._361507a1673cfabfb4f9240965fcfe53.test
import org.gradle.kotlin.dsl.`java-library`

plugins {
    id("java-library")
    id("checkstyle")
}
java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(11))
    targetCompatibility = JavaVersion.VERSION_11
    sourceCompatibility = JavaVersion.VERSION_11
}
checkstyle{
    maxWarnings = 0
}
tasks.test {
    useJUnitPlatform()
}