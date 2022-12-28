package com.currencyconvertor.kafka.streamtest;

import org.apache.kafka.streams.StreamsConfig;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StreamConfig {
	
	@Bean
	public StreamsConfig createStreamsConfig(KafkaProperties kafkaProps) {
		System.out.println("=======>>> Inside createStreamsConfig()");
		return new StreamsConfig(kafkaProps.buildStreamsProperties());
	}
}
