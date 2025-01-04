package Airbnb.Clone.Airbnb.Clone.Repository;

import Airbnb.Clone.Airbnb.Clone.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
