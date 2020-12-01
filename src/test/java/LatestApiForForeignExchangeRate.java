

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
public class LatestApiForForeignExchangeRate {

	@Test
	public void getLatestExchangeRates()
	{
	given()
	.when() 
	.get("https://api.exchangeratesapi.io/latest")
	.then()
	.statusCode(200)
	.assertThat().body("https://api.exchangeratesapi.io/latest",equalTo("88.3015"))
	.header("Content-Type","application/json");
	}


}
