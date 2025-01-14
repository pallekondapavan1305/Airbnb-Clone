package Airbnb.Clone.Airbnb.Clone.Controller;

import Airbnb.Clone.Airbnb.Clone.Entity.Booking;
import Airbnb.Clone.Airbnb.Clone.Service.BookingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    private BookingServices bookingServices;

    @PostMapping
    public Booking createBooking(@RequestParam Long propertyId,
                                 @RequestParam LocalDate startDate,
                                 @RequestParam LocalDate endDate){
        return bookingServices.createBooking(propertyId,startDate,endDate);
    }

    @GetMapping("/{id}")
    public Booking getBookingbyId(@PathVariable Long id){
        return bookingServices.getBookingById(id);
    }

    @GetMapping
    public List<Booking> getAllBookings(){
        return bookingServices.getAllBookings();
    }

    @GetMapping("/property/{property}")
    public List<Booking> getBookingByProperty(@PathVariable Long propertyId){
        return bookingServices.getBookingsByProperty(propertyId);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id){
        bookingServices.deleteBooking(id);
    }

}
