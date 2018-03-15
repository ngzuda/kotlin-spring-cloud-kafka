package com.zuda.cloud.configuration

import com.zuda.cloud.stream.GreetingsStreams
import org.springframework.cloud.stream.annotation.EnableBinding

@EnableBinding(GreetingsStreams::class)
class StreamsConfig