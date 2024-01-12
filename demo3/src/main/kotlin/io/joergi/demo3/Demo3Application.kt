package io.joergi.demo3

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Demo3Application

fun main(args: Array<String>) {
	runApplication<Demo3Application>(*args)
	println("hello world")
}
