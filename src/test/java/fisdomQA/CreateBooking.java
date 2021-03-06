package fisdomQA;



import Reusable.Payloads;
import Reusable.Resources;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


//@Listeners(utils.Listeners.class)
public class CreateBooking {
	
@Test

public void createBooking() {
	
	RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
	
	Response response = given().header("Content-Type","application/json").header("Accept","application/json").
	
	body(Payloads.CreateBooking).
	
	when().post(Resources.createBooking()).
	
	then().assertThat().statusCode(200).
	
	extract().response();
	
	String responseString = response.asString();
	
	//System.out.println("responseString:" + responseString);
	
}


}
