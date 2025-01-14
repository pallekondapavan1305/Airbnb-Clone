package Airbnb.Clone.Airbnb.Clone.Controller;


import Airbnb.Clone.Airbnb.Clone.Entity.User;
import Airbnb.Clone.Airbnb.Clone.Repository.UserRepository;
import Airbnb.Clone.Airbnb.Clone.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAlluser();
    }

    @PostMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet( () -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
