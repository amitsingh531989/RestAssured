package com.common.services;

import static com.rest.common.Constants.BASE_URL;
import static com.rest.common.Constants.REQUESTSPECIFICATION;
import static io.restassured.RestAssured.given;


import java.util.Map;

import org.json.JSONException;

import io.restassured.response.Response;

public class ExchangeRate {

	public static Response getLatestExchangeRates() throws JSONException {
		// keeping site query parameter as this is mandatory.
		return given().spec(REQUESTSPECIFICATION).queryParam("site", "stackoverflow").when().get(BASE_URL + "latest/");
	}
	
	public static Response getLatestExchangeRates(String URI) throws JSONException {
		// keeping site query parameter as this is mandatory.
		return given().spec(REQUESTSPECIFICATION).queryParam("site", "stackoverflow").when().get(BASE_URL + URI);
	}
}
