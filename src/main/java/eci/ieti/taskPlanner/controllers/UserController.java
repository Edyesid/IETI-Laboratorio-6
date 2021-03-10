package eci.ieti.taskPlanner.controllers;

import eci.ieti.taskPlanner.Model.User;
import eci.ieti.taskPlanner.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping(value = "/usuarios")
    public ResponseEntity<?> getUsers() {
        return new ResponseEntity<>("hola", HttpStatus.ACCEPTED);
    }
    /*@PostMapping(value = "/create")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        User userCreate = userService.create(user);
        return new ResponseEntity<>(userCreate, HttpStatus.CREATED);
    }*/
}
