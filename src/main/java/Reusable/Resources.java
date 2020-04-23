package Reusable;

public class Resources {
	
	public static String createToken() {
		return "auth";
	}
	
	public static String createBooking() {
		return "booking";
	}

	public static String createBookingById(String bookingId) {
		String bookingID= "booking/"+ bookingId;
		//System.out.println(bookingID);
		return bookingID;
	}
}
