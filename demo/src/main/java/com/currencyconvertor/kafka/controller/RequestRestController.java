package com.currencyconvertor.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.currencyconvertor.kafka.Producer;
import com.currencyconvertor.kafka.Wrapper.PaymentWrapper;

@RestController
@RequestMapping("/api/kafka")
public class RequestRestController {
	
	@Autowired
	Producer producer;
	
	@PostMapping("/sendToTopic")
	public ResponseEntity<Object> sendMsgToKafka(@RequestBody PaymentWrapper paymentMessage){
		producer.sendMessageToTopic(paymentMessage);
		System.out.println("Message Sent::>"+ paymentMessage);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
