package Airbnb.Clone.Airbnb.Clone.Service;


import Airbnb.Clone.Airbnb.Clone.Entity.Property;
import Airbnb.Clone.Airbnb.Clone.Entity.User;
import Airbnb.Clone.Airbnb.Clone.Repository.PropertyRepository;
import Airbnb.Clone.Airbnb.Clone.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {


    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private UserRepository userRepository;

    public Property createProperty(Property property,Long userId){
        User owner = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        property.setOwner(owner);
        return propertyRepository.save(property);
    }

    public Property getPropertyById(Long id){
        return propertyRepository.findById(id).orElseThrow(() -> new RuntimeException("property not found"));
    }

    public List<Property> getAllProperties(){
        return propertyRepository.findAll();
    }

}
