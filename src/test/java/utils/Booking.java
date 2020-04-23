package utils;



import Reusable.Payloads;
import Reusable.Resources;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Booking {
	
	
	Response response;
	
	@BeforeTest
	
	public void BaseURL() {
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
		
	}
	
@Test(enabled=true)
 
public void createToken() {

  given().header("Content-Type","application/json").body(Payloads.CreateToken).
  
  when().post(Resources.createToken()).
  
  then().assertThat().statusCode(200).
  
  extract().response();
}


@Test(enabled=true)

public void createBooking() {
	
	response = given().header("Content-Type","application/json").header("Accept","application/json").
	
	body(Payloads.CreateBooking).
	
	when().post(Resources.createBooking()).
	
	then().assertThat().statusCode(200).
	
	extract().response();
	
	String responseString = response.asString();
	
	System.out.println("responseString:" + responseString);
	
}
@Test(enabled=true)
public void getBookingByName() {
	
	response =given().param("firstname", "Sharik").param("lastname","Abbas").
	
	when().get(Resources.createBooking()).
	
	then().assertThat().statusCode(200).
	
	extract().response();
	
	String responseString =response.asString();
	
	System.out.println("responseString:"+ responseString);
	
}

@Test(enabled=true)

public void getBookingById() throws Exception {
	
	response = given().header("Content-Type","application/json").header("Accept","application/json").
			
			body(Payloads.CreateBooking1).
			
			when().post(Resources.createBooking()).
			
			then().assertThat().statusCode(200).
			
			extract().response();
			
			String responseString = response.asString();
			
			System.out.println("responseString:" + responseString);
			
			JsonPath jp = new JsonPath(responseString);
			
			String bookingId = jp.getString("bookingid");
			
			Response response1 =given().header("Accept","application/json").
			
			when().get(Resources.createBookingById(bookingId)).
			
			then().assertThat().statusCode(200).
			
			extract().response();
			
			String getResponse = response1.asString();
			
			System.out.println("ResponseString:" + getResponse);
			
}

@Test(enabled = true)
public void updateBooking() {
	
			response =given().header("Content-Type","application/json").body(Payloads.CreateToken).
	  
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
			
			System.out.println("responseString:" + responseString);
			
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

@Test(enabled = false)
public void partialUpdateBooking() {
	
	response =given().header("Content-Type","application/json").body(Payloads.CreateToken).
			  
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
			
			System.out.println("responseString:" + responseString);
			
			JsonPath jp = new JsonPath(responseString);
			
			String bookingId = jp.getString("bookingid");
			
			given().
			
			header("Content-Type","application/json").
			
			header("Accept","application/json").
			
			header("Cookie","token="+tokenHeader).
			
			body(Payloads.PartialUpdate).
			
			when().put(Resources.createBookingById(bookingId)).
			
			then().assertThat().statusCode(200).
			
			extract().response();
	
}

}
