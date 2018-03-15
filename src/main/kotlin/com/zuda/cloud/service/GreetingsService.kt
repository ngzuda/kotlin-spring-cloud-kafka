package com.zuda.cloud.service

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.zuda.cloud.model.Greetings
import com.zuda.cloud.stream.GreetingsStreams
import mu.KotlinLogging
import org.springframework.messaging.MessageHeaders
import org.springframework.messaging.support.GenericMessage
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Service
import org.springframework.util.MimeTypeUtils

@Service
class GreetingsService(private val greetingsStreams: GreetingsStreams) {

    companion object {
        val LOGGER = KotlinLogging.logger { }
    }

    fun sendGreeting(greetings: Greetings) {
        LOGGER.info("Sending greetings $greetings")
        val messageChannel = greetingsStreams.outboundGreetings()
        val greetings = MessageBuilder.withPayload(greetings).setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build()
        messageChannel.send(greetings)
    }
}