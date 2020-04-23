package fisdomQA;



import Reusable.Payloads;
import Reusable.Resources;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchBookingById {
	
@Test
public void getBookingById() throws Exception {
	
			RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
	
			Response response = given().header("Content-Type","application/json").header("Accept","application/json").
			
			body(Payloads.CreateBooking1).
			
			when().post(Resources.createBooking()).
			
			then().assertThat().statusCode(200).
			
			extract().response();
			
			String responseString = response.asString();
			
			//System.out.println("responseString:" + responseString);
			
			JsonPath jp = new JsonPath(responseString);
			
			String bookingId = jp.getString("bookingid");
			
			Response response1 =given().header("Accept","application/json").
			
			when().get(Resources.createBookingById(bookingId)).
			
			then().assertThat().statusCode(200).
			
			extract().response();
			
			String getResponse = response1.asString();
			
			//System.out.println("ResponseString:" + getResponse);
			
}

}
