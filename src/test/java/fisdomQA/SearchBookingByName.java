package fisdomQA;



import Reusable.Payloads;
import Reusable.Resources;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchBookingByName {
	
@Test
public void getBookingByName() {
	 
			RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
	
			given().header("Content-Type","application/json").header("Accept","application/json").
			
			body(Payloads.CreateBooking).
			
			when().post(Resources.createBooking()).
			
			then().assertThat().statusCode(200).
			
			extract().response();
	
			Response response =given().param("firstname", "Sharik").param("lastname","Abbas").
	
			when().get(Resources.createBooking()).
	
			then().assertThat().statusCode(200).
	
			extract().response();
	
			String responseString =response.asString();
	
			//System.out.println("responseString:"+ responseString);
	
}

}
