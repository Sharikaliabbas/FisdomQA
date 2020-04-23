package fisdomQA;



import Reusable.Payloads;
import Reusable.Resources;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.XLUtils;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateBooking_Data {
	
@Test(dataProvider="Bookings")
public void createBooking(String JSONBody) {
	
	RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
	
	//System.out.println("JSON:"+JSONBody);
	Response response = given().header("Content-Type","application/json").header("Accept","application/json").
	
	body(JSONBody).
	
	when().post(Resources.createBooking()).
	
	then().assertThat().statusCode(200).
	
	extract().response();
	
	String responseString = response.asString();
	
	//System.out.println("responseString:" + responseString);

	
}


@DataProvider(name="Bookings")
	
	String [][] bookTickets() throws Exception
{
	String path = System.getProperty("user.dir")+ "/XLS_READER.xlsx";
	//System.out.println(path);
	
	int rownum = XLUtils.getRowCount(path, "CreateBooking");
	//System.out.println("row:"+rownum);
	
	/*int colnum = XLUtils.getCellCount(path, "CreateBooking", 1);
	System.out.println("col:"+colnum);*/
	
	int colnum =1;
	
	String booking [][] = new String [rownum][colnum];
	
	for(int i=1;i<=rownum;i++) {
		
		for(int j=0;j<colnum;j++) {
		
			booking[i-1][j] = XLUtils.getCellData(path, "CreateBooking", i, j);
		}
	}
	
	return (booking);
	
		
	}
}

