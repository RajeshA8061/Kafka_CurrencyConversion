package com.currencyconvertor.kafka.Wrapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentWrapper {

	private Long txnId;

	private String sourceCurrency;

	private Double sourceAmount;
	
	private String targetCurrency;

	private Double targetAmount;

}
