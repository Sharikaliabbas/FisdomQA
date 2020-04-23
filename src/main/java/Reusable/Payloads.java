package Reusable;

public class  Payloads {

	public static String CreateToken = "{\"username\" : \"admin\",\"password\" : \"password123\"}";
	
	public static String InvalidToken = "{\"username\" : \"ADMIN\",\"password\" : \"PASSWORD123\"}";
	
	public static String CreateBooking = "{\"firstname\" : \"Sharik\",\"lastname\" : \"Abbas\",\"totalprice\" : 9723,\"depositpaid\" : true,\"bookingdates\" : {\"checkin\" : \"2020-05-21\",\"checkout\" : \"2020-06-06\"},\"additionalneeds\" : \"Breakfast\"}";

	public static String IncorrectPayload = "{\"firstname\" : \"Sharik\",\"lastname\" : \"Abbas\",\"Totalprice\" : 9723,\"depositpaid\" : true,\"bookingdates\" : {\"checkin\" : \"2020-05-21\",\"checkout\" : \"2020-06-06\"},\"additionalneeds\" : \"Breakfast\"}";
	
	public static String CreateBooking1 = "{\"firstname\" : \"Cristiano\",\"lastname\" : \"Ronaldo\",\"totalprice\" : 9723,\"depositpaid\" : true,\"bookingdates\" : {\"checkin\" : \"2020-05-21\",\"checkout\" : \"2020-06-06\"},\"additionalneeds\" : \"Breakfast\"}";

	public static String CreateBooking2 = "{\"firstname\" : \"Vinicius\",\"lastname\" : \"Junior\",\"totalprice\" : 9723,\"depositpaid\" : true,\"bookingdates\" : {\"checkin\" : \"2020-05-21\",\"checkout\" : \"2020-06-06\"},\"additionalneeds\" : \"Breakfast\"}";

	public static String CreateBooking3 = "{\"firstname\" : \"Eden\",\"lastname\" : \"Hazard\",\"totalprice\" : 9723,\"depositpaid\" : true,\"bookingdates\" : {\"checkin\" : \"2020-05-21\",\"checkout\" : \"2020-06-06\"},\"additionalneeds\" : \"Breakfast\"}";

	public static String PartialUpdate = "{\"firstname\" : \"Eden\",\"lastname\" : \"Hazard\",\"totalprice\" : 9723,\"depositpaid\" : true,\"bookingdates\" : {\"checkin\" : \"2020-05-21\",\"checkout\" : \"2020-06-06\"}}";

	public static String EmptyPayload = "";

}
