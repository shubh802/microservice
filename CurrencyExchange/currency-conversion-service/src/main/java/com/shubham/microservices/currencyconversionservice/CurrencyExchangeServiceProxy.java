package com.shubham.microservices.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// In the Feign client we dont want url as we dont want to listen to one
// particular instance but to a list of the instances
//@FeignClient(name="currency-exchange-service",url="localhost:8000")
//@FeignClient(name="currency-exchange-service")
@FeignClient(name="netflix-zuul-api-gateway-server")
// Configuring the ribbon it helps the feign client to distribute calls
// To the different servers like load balancer
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
//	@GetMapping(/currency-exchange/from/{from}/to/{to}")
//	For zuul server
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
