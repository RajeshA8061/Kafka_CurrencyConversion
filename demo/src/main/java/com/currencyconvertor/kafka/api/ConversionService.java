package com.currencyconvertor.kafka.api;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.currencyconvertor.kafka.Wrapper.CurrConvApiResponse;
import com.currencyconvertor.kafka.Wrapper.PaymentWrapper;

@Component
public class ConversionService {

	public static final String API_URL = "https://api.api-ninjas.com/v1/convertcurrency";

	public CurrConvApiResponse convertViaService(PaymentWrapper wrapper) {
		CurrConvApiResponse response = null;
			if (wrapper.getSourceCurrency()!=null){
				System.out.println(wrapper.getSourceCurrency() +"|| " + wrapper.getTargetCurrency() +"|| " + wrapper.getSourceAmount());
				WebClient wc = WebClient.builder().baseUrl(API_URL).build();
				 response = wc.get()
																			.uri(t -> t
																			.queryParam("have", "{1}")
																			.queryParam("want", "{2}")
																			.queryParam("amount", "{3}")
																			.build(wrapper.getSourceCurrency(), wrapper.getTargetCurrency(), wrapper.getSourceAmount()))
																			.header("X-Api-Key", "xcvKm6ECjtzogdxCyyFVAA==5nDU4NH6aEI8hxHu")
																			.accept(MediaType.APPLICATION_JSON)
																			.retrieve().bodyToMono(CurrConvApiResponse.class).block();
				System.out.println("RESPONSE::>" +response);
				
		}
			return response;	
	}

}
