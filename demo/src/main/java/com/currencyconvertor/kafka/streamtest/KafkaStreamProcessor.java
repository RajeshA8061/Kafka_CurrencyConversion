package com.currencyconvertor.kafka.streamtest;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.serializer.JsonSerde;
import org.springframework.stereotype.Component;

import com.currencyconvertor.kafka.Wrapper.CurrConvApiResponse;
import com.currencyconvertor.kafka.Wrapper.PaymentWrapper;
import com.currencyconvertor.kafka.api.ConversionService;

import jakarta.annotation.PostConstruct;

@Component
public class KafkaStreamProcessor {
	
	@Autowired
	StreamsBuilder streamsBuilder;
	
	@Autowired
	ConversionService cs;
	
	@PostConstruct
	public void processStreamMessages() {
		JsonSerde<PaymentWrapper> serde = new JsonSerde<>();
		serde.deserializer().addTrustedPackages("com.currencyconvertor.kafka.Wrapper");
		KStream<String, PaymentWrapper> kStream = streamsBuilder.stream("currencyConversion_Topic", Consumed.with(Serdes.String(), serde) );
		
		kStream.foreach((k,v) ->{
			CurrConvApiResponse convertViaService = cs.convertViaService(v);
			v.setTargetAmount(convertViaService.getNew_amount());
		}) ;
		
		kStream.peek( (k,v) -> System.out.println("Final Converted Msg:: " + v)).to("convertedCurrency_Topic", Produced.with(Serdes.String(),serde));;

	}
	
}
