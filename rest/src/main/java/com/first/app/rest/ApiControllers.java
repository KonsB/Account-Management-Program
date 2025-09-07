package com.first.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiControllers {

    @Autowired
    private UserService userService;
    
    @GetMapping("/users")
    public List<UserDTO> getAllUsers() throws Exception {
        return userService.getUsers();
    }
    
    @PostMapping("/save")
    public String saveUser(@RequestBody UserDTO userDto) throws Exception {
        return userService.saveUser(userDto);
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody UserDTO userDto) throws Exception {
        return userService.updateUser(id, userDto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id) throws Exception {
        return userService.deleteUser(id);
    }
}