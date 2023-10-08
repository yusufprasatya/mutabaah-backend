package com.mutabaah.Mutabaah.Backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class MutabaahBackendApplication

fun main(args: Array<String>) {
	runApplication<MutabaahBackendApplication>(*args)
}
