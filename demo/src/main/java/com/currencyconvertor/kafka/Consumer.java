/*
 * package com.currencyconvertor.kafka;
 * 
 * import org.springframework.kafka.annotation.KafkaListener; import
 * org.springframework.stereotype.Service;
 * 
 * import com.currencyconvertor.kafka.Wrapper.PaymentWrapper;
 * 
 *@Service public class Consumer {
 * 
 * 
 *@KafkaListener(topics = "currencyConversion_Topic") public void
 * listenToTopic(PaymentWrapper wrapper) {
 * System.out.println("MESSAGE RECEIVED BY LISTENER:::> " + wrapper);
 * 
 * 
 * }
 * 
 * }
 */