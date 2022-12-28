package com.currencyconvertor.kafka.Wrapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrConvApiResponse {

	private Double old_amount;
	private String old_currency;
	
	private Double new_amount;
	private String new_currency;
	
}
