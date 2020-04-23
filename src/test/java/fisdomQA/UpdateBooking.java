package fisdomQA;



import Reusable.Payloads;
import Reusable.Resources;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UpdateBooking {

@Test
public void updateBooking() {
	
			RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
	
			Response response =given().header("Content-Type","application/json").body(Payloads.CreateToken).
	  
			when().post(Resources.createToken()).
	  
			then().assertThat().statusCode(200).
	  
			extract().response();
			
			String token = response.asString();
			
			JsonPath JP = new JsonPath(token);
			
			String tokenHeader= JP.getString("token");
			
			
			response = given().
					
					
			header("Content-Type","application/json").
			
			header("Accept","application/json").
			
			body(Payloads.CreateBooking2).
			
			when().post(Resources.createBooking()).
			
			then().assertThat().statusCode(200).
			
			extract().response();
			
			String responseString = response.asString();
			
			//System.out.println("responseString:" + responseString);
			
			JsonPath jp = new JsonPath(responseString);
			
			String bookingId = jp.getString("bookingid");
			
			given().
			
			header("Content-Type","application/json").
			
			header("Accept","application/json").
			
			header("Cookie","token="+tokenHeader).
			
			body(Payloads.CreateBooking3).
			
			when().put(Resources.createBookingById(bookingId)).
			
			then().assertThat().statusCode(200).
			
			extract().response();
	
}
}