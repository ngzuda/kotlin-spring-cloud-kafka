package com.zuda.cloud.web

import com.zuda.cloud.model.Greetings
import com.zuda.cloud.service.GreetingsService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingsController(private val greetingsService: GreetingsService) {

    @GetMapping("/greetings")
    fun greetings(message: String) {
        val greetings = Greetings(message = message, timeStamp = System.currentTimeMillis())
        greetingsService.sendGreeting(greetings = greetings)
    }


}