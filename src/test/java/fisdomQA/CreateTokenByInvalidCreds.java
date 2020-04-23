package fisdomQA;



import Reusable.Payloads;
import Reusable.Resources;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateTokenByInvalidCreds {
	
@Test(enabled=true)
public void createTokenByInvalidCreds() {

	RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
	
	given().header("Content-Type","application/json").body(Payloads.InvalidToken).
  
  when().post(Resources.createToken()).
  
  then().assertThat().statusCode(401).
  
  extract().response();
}
}
