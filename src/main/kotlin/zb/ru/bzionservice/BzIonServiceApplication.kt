package zb.ru.bzionservice

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BzIonServiceApplication

fun main(args: Array<String>) {
	runApplication<BzIonServiceApplication>(*args)
//	SpringApplication.run(zb.ru.bzionservice.BzIonServiceApplication::class.java, *args)
}
