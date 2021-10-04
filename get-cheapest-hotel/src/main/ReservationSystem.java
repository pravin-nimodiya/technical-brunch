package main;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ReservationSystem {
    private final List<Hotel> hotels;

    public ReservationSystem(List<Hotel> hotels) {
        this.hotels = hotels;
    }

	public Hotel findCheapestHotel(Date checkInDate, Date checkoutDate) throws Exception {
		Optional<Hotel> cheapestHotel =  hotels.stream().filter(hotel -> hotel.isAvailableForDate(checkInDate, checkoutDate))
				.sorted(Comparator.comparingDouble(Hotel::getRate)).findFirst();
		if(cheapestHotel.isPresent()) return cheapestHotel.get();
		else throw new NoHotelsAvailableException(NoHotelsAvailableException.NO_HOTELS_AVAIALBE);
	}
}
