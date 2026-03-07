package de.hwr.pressregret

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PressRegretBackendApplication

fun main(args: Array<String>) {
	runApplication<PressRegretBackendApplication>(*args)
}
