package com.RestAssuredBDDProject.Tests;

import static com.rest.common.Constants.HTTP_OK;
import static com.rest.common.Constants.HTTP_BAD_REQUEST;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.common.services.ExchangeRate;

import io.restassured.response.Response;

public class LatestApiForForeignExchangeRate {

	final static String Date = "2020-11-30";
	final static String Previous_Date = "2019-10-15";
	final static String Future_Date = "2021-01-05";

	@Test(description = "An automated test suite should run which will assert the success status of the response", priority = 1)
	public void getLatestExchangeRates() {
		Response exchangeRateService = ExchangeRate.getLatestExchangeRates();
		assertEquals(exchangeRateService.getStatusCode(), HTTP_OK);
	}

	@Test(description = "An automated test suite should run which will assert the response", priority = 2)
	public void verifyExchangeRateResponseForAP() {
		Response exchangeRateService = ExchangeRate.getLatestExchangeRates();
		assertEquals(exchangeRateService.getBody().path("base"), "EUR");

	}

	@Test(description = "An automated test suite should run which will assert the success status of the response", priority = 3)
	public void verifyExchangeRateWithInvalidURL() {
		Response exchangeRateService = ExchangeRate.getLatestExchangeRates("ABC");
		assertEquals(exchangeRateService.statusCode(), HTTP_BAD_REQUEST);
	}

	@Test(description = "An automated test suite should run which will assert the success status of the response", priority = 4)
	public void verifyExchangeRateWithPreviousDate() {
		Response exchangeRateService = ExchangeRate.getLatestExchangeRates(Previous_Date);
		assertEquals(exchangeRateService.statusCode(), HTTP_OK);

	}

	@Test(description = "An automated test suite should run which will assert the success status of the response", priority = 5)
	public void verifyExchangeRateForSpecificDate() {
		Response exchangeRateService = ExchangeRate.getLatestExchangeRates(Previous_Date);
		assertEquals(exchangeRateService.statusCode(), HTTP_OK);
		assertEquals(exchangeRateService.getBody().path("date"), Previous_Date);
	}

	@Test(description = "An automated test suite should run which will assert the success status of the response", priority = 5)
	public void verifyExchangeRateResponseForFutureDate() {

		Response exchangeRateService = ExchangeRate.getLatestExchangeRates(Future_Date);
		assertEquals(exchangeRateService.statusCode(), HTTP_OK);
		assertEquals(exchangeRateService.getBody().path("date"), Date);

	}
}
