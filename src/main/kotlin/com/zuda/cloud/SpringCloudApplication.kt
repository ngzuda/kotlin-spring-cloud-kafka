package com.zuda.cloud

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringCloudApplication

fun main(args: Array<String>) {
    runApplication<SpringCloudApplication>(*args)
}
