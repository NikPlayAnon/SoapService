package zb.ru.bzionservice.configuration

import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.Resource
import org.springframework.core.io.support.PropertiesLoaderUtils
import java.io.File
import java.nio.file.Paths
import java.util.*


@Configuration
class Config {
    // Given file path
    val filePath = Paths.get("").toAbsolutePath().toString()+"/application-override.properties" // Replace with the path to your file

    // Create File object with the file path
    val file = File(filePath)

    @Value("\${list.of.exturnal.properties}")
    private lateinit var propertyList: List<String>

    @PostConstruct
    fun init() {
        // Check if file exists
        if (file.exists()) {
            println("The file '$filePath' exists.")
        } else {
            println("The file '$filePath' does not exist.")
            File(filePath).writeText("")

            for (key in propertyList) {
                val resource: Resource = ClassPathResource("classpath:application.properties")
                val props: Properties = PropertiesLoaderUtils.loadProperties(resource)
                File(filePath).appendText("${key.toString()} = ${props.getProperty(key)}" + System.getProperty("line.separator"))
            }
        }
    }


}