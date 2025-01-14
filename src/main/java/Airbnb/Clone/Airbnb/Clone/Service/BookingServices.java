package Airbnb.Clone.Airbnb.Clone.Service;

import Airbnb.Clone.Airbnb.Clone.Entity.Booking;
import Airbnb.Clone.Airbnb.Clone.Entity.Property;
import Airbnb.Clone.Airbnb.Clone.Repository.BookingRepository;
import Airbnb.Clone.Airbnb.Clone.Repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingServices {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    public Booking createBooking(Long propertyId, LocalDate startDate,LocalDate endDate){

        Property property = propertyRepository.findById(propertyId).
                orElseThrow(() ->new RuntimeException("Property not found"));

        Booking booking = new Booking();
        booking.setProperty(property);
        booking.setStartData(startDate);
        booking.setEndData(endDate);

        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();

    }

    // get booking by PropertyID.
    public List<Booking> getBookingByProperty(Long propertyId) {
        return bookingRepository.findByPropertyId(propertyId);
    }
    
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

}


