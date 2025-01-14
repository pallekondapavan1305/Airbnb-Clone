package Airbnb.Clone.Airbnb.Clone.Service;

import Airbnb.Clone.Airbnb.Clone.Entity.User;
import Airbnb.Clone.Airbnb.Clone.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //get all user
    public List<User> getAlluser(){
        return userRepository.findAll();
    }
    //create user
    public User CreateUser(User user){
        return userRepository.save(user);
    }
    //userbyid
    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }
    //deleteuser

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
