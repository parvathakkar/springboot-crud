package com.example.ThinkOn.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * controller to handle resources for API
 */
@RestController
@RequestMapping(path = "api/user")
public class UserController {

    /**
     * Initialise the user service object which holds the api methods (bean)
     */
    private final UserService userService;

    /**
     * Constructor for the controller which uses the service
     */
    @Autowired //injects the bean into the constructor
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping // we want to get something from the server (GET)
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(path="{userId}")
    public User getUser(@PathVariable("userId") Long userId) {
        return userService.getUser(userId);
    }

    @PostMapping //POST - we parse in the client request which will be the user. Request body will be mapped into the user object
    public void registerNewUser(@RequestBody User user) {
        userService.addNewUser(user);
    }

    @DeleteMapping(path="{userId}") // this means that a user id needs to be specified
    //path variable indicates that the parameter in the path which corresponds to the id is stored and parsed
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }

    //requested param makes it so that it would look for the variable within the url to parse in
    @PutMapping(path="{userId}")
    public void updateUser(@PathVariable("userId")Long userId, @RequestParam(required = false) String updatedName) {
        userService.updateUser(userId,updatedName);
    }
}
