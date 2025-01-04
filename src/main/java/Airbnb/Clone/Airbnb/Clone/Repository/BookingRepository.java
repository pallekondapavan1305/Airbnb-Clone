package Airbnb.Clone.Airbnb.Clone.Repository;

import Airbnb.Clone.Airbnb.Clone.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
}
