package com.dbproject.dbconnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/demo")
public class MainController {
    @Autowired // to connect with user repositry
    private UserRepository userRepository; // it is save in spring container like this

    @PostMapping(path = "/add")
    public @ResponseBody User addNewUser(@RequestParam String name,@RequestParam String email){
        User springUser = new User();
        springUser.setName(name);
        springUser.setEmail(email);
        userRepository.save(springUser);
        return springUser;
    }

    @GetMapping(path = "/getall")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }
}
