package myproject.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import java.nio.file.Files
import java.nio.file.attribute.PosixFilePermission

abstract class GenerateStartScript: DefaultTask() {

    @get:Input
    abstract val mainClass:Property<String>

    @get:OutputFile
    abstract val scriptFile:RegularFileProperty

    @TaskAction
    fun generate(){
        val main = mainClass.get() //string value
        val output = scriptFile.get().asFile // java.io.file
        val script = "java -cp \"libs/*\" $main"
        output.writeText(script)
        Files.setPosixFilePermissions(output.toPath(), setOf(
            PosixFilePermission.OWNER_READ,
            PosixFilePermission.OWNER_WRITE,
            PosixFilePermission.OWNER_EXECUTE,
            PosixFilePermission.GROUP_READ,
            PosixFilePermission.GROUP_EXECUTE,
            PosixFilePermission.OTHERS_READ,
            PosixFilePermission.OTHERS_EXECUTE
        ))
    }
}