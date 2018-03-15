package com.zuda.cloud.service

import com.zuda.cloud.model.Greetings
import com.zuda.cloud.stream.GreetingsStreams
import mu.KotlinLogging
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class GreetingsListener {

    companion object {
        val LOGGER = KotlinLogging.logger { }
    }

    @StreamListener(GreetingsStreams.INPUT)
    fun handleGreetings(@Payload greetings: Greetings) {
        LOGGER.info("Received greetings $greetings")
    }
}