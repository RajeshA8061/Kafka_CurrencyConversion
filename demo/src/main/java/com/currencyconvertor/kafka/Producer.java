package com.currencyconvertor.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.currencyconvertor.kafka.Wrapper.PaymentWrapper;

@Service
public class Producer {
	
	@Autowired
	KafkaTemplate<String, PaymentWrapper> kafkaTemplate;
	
	public void sendMessageToTopic(PaymentWrapper wrapper) {
		kafkaTemplate.send("currencyConversion_Topic", wrapper);
		System.out.println("Message sent to Kafka Topic::> currencyConversion_Topic" );
	}

}
