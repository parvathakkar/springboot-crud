package com.example.ThinkOn.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired //inject the repo
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // GET /users - get a list of users
    public List<User> getUsers() {
        return userRepository.findAll(); //returns a list of all the users
    }

    //POST /users - create a new user
    public void addNewUser(User user) {
        Optional<User> userEmail = userRepository.findUserByEmail(user.getEmail());
        if (userEmail.isPresent()) { //this will check if the email already exists within the database
            throw new IllegalStateException("User already exists");
        }
        userRepository.save(user); //else, allow the post
    }

    //DELETE /users/{id}
    public void deleteUser(Long userId) {
        boolean userExists = userRepository.existsById(userId);
        if (!userExists) { //cannot delete the user if it does not exist
            throw new IllegalStateException("User with id " + userId + " does not exist");
        }
        userRepository.deleteById(userId); // else go ahead with the delete request
    }

    /**
     * This method specifically updates the users first name
     */
    // PUT /users/{id}
    @Transactional //entity goes into a managed state
    public void updateUser(Long userId, String updatedName) {
        boolean userExists = userRepository.existsById(userId);
        if (!userExists) {
            throw new IllegalStateException("User with id " + userId + " does not exist");
        }
        User user = userRepository.findById(userId).orElse(null);

        // check that the requested name change isn't the same as the current one
        if (updatedName.equals(user.getFirst_name())) {
            throw new IllegalStateException("Updated name cannot be the same as the current name");
        }
        user.setFirst_name(updatedName);
    }

    //GET /users/{id}
    public User getUser(Long userId) {
        boolean userExists = userRepository.existsById(userId);
        if (!userExists) {
            throw new IllegalStateException("User with id " + userId + " does not exist");
        }
        return userRepository.findById(userId).orElse(null); //return the user with the provided id
    }
}
