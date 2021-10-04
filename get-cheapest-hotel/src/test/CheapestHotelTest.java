package test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.Hotel;
import main.ReservationSystem;
import main.exception.InputException;
import main.exception.NoHotelsAvailableException;
import main.utils.TimeUtility;

public class CheapestHotelTest {


	/*@Test
    public void findCheapestHotel(){
        Hotel MiamiBeach = new Hotel(80, "Miami Beach");
        Hotel MiamiDowntown = new Hotel(120, "Miami Downtown");
        Hotel MiamiMidtown = new Hotel(100, "Miami Midtown");
        List<Hotel> hotelList = new ArrayList<>();
        hotelList.add(MiamiDowntown);
        hotelList.add(MiamiBeach);
        hotelList.add(MiamiMidtown);
        ReservationSystem reservationSystem = new ReservationSystem(hotelList);
        Hotel cheapestHotel = reservationSystem.findCheapestHotel(null, null); //TODO provides input
        assertEquals(MiamiBeach, cheapestHotel);
    }*/
    
    @Test
	public void findChepeastHotelInGivenDateRange() {

		try {
			Date checkInDate = TimeUtility.getUtcTime("05-10-2021");
			Date checkoutDate = TimeUtility.getUtcTime("07-10-2021");


			Hotel MiamiBeach = new Hotel(80, "Miami Beach");
			Hotel MiamiDowntown = new Hotel(120, "Miami Downtown");
			Hotel MiamiMidtown = new Hotel(100, "Miami Midtown");
			List<Hotel> hotelList = new ArrayList<>();
			hotelList.add(MiamiDowntown);
			hotelList.add(MiamiBeach);
			hotelList.add(MiamiMidtown);
			
			ReservationSystem reservationSystem = new ReservationSystem(hotelList);
			Hotel cheapestHotel = reservationSystem.findCheapestHotel(checkInDate,checkoutDate);
			System.out.println("cheapest hotel for your query is "+ cheapestHotel.getName()+ " costing Rs :- "+cheapestHotel.getRate());
			assertEquals(MiamiBeach, cheapestHotel);
		} catch (Exception e) {
			if (e instanceof InputException)
				fail(e.getMessage());
			fail("The application failed to provide solution for the given input");
		}
	}
    
    @Test
	public void checkIfNoHotelAvaialbe() {

		try {
			Date checkInDate = TimeUtility.getUtcTime("05-10-2021");
			Date checkoutDate = TimeUtility.getUtcTime("07-10-2021");

			Hotel miamiBeach = new Hotel(80, "Miami Beach");
			miamiBeach.setAvailabe(false);
			Hotel miamiDowntown = new Hotel(120, "Miami Downtown");
			miamiDowntown.setAvailabe(false);
			Hotel miamiMidtown = new Hotel(100, "Miami Midtown");
			miamiMidtown.setAvailabe(false);
			List<Hotel> hotelList = new ArrayList<>();
			hotelList.add(miamiBeach);
			hotelList.add(miamiDowntown);
			hotelList.add(miamiMidtown);

			ReservationSystem reservationSystem = new ReservationSystem(hotelList);
			Hotel cheapestHotel;
			try {
				cheapestHotel = reservationSystem.findCheapestHotel(checkInDate, checkoutDate);
				System.out.println("cheapest hotel for your query is " + cheapestHotel.getName() + " costing Rs :- "
						+ cheapestHotel.getRate());
				assertEquals(miamiBeach, cheapestHotel);
			} catch (Exception e) {
				if(e instanceof NoHotelsAvailableException) {
					assertEquals(NoHotelsAvailableException.NO_HOTELS_AVAIALBE, e.getMessage());
					System.out.println(e.getMessage());
				}
				else throw e;
			}
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
