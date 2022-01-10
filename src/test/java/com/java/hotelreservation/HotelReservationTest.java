package com.java.hotelreservation;
import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest {
	@Test

	public void givenHotelDetails_WhenValuesEnteredAreCorrect_ShouldReturnTrue() {
		
		 HotelReservation hotelreservation = new HotelReservation();
		 boolean result = hotelreservation.AddHotel();
		 Assert.assertEquals(true,result);
	}

}
