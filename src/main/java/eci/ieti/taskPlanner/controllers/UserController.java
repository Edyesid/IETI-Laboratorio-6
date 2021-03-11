package eci.ieti.taskPlanner.controllers;

import eci.ieti.taskPlanner.Model.User;
import eci.ieti.taskPlanner.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public ResponseEntity<?> getUsers() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.ACCEPTED);
    }
    @PostMapping(value = "/create")
    public ResponseEntity<?> createUser() {
        User user = new User("123-456-789","usuario nuevo", "email@gmail.com", "prueba123");
        User userCreate = userService.create(user);
        return new ResponseEntity<>(userCreate, HttpStatus.CREATED);
    }
    @PutMapping(value = "/update")
    public ResponseEntity<?> updateUser() {
        User user = new User("123", "usuario update", "update@gmail.com", "prueba123");
        User userCreate = userService.update(user);
        return new ResponseEntity<>(userCreate, HttpStatus.ACCEPTED);
    }
    @DeleteMapping (value = "/delete/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") String userId) {
        userService.remove(userId);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }
}
