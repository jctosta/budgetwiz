package com.budget.wiz.skip.app.controller;

import com.budget.wiz.skip.app.domain.object.Budget;
import com.budget.wiz.skip.app.domain.object.User;
import com.budget.wiz.skip.app.repository.UserRepository;
import com.budget.wiz.skip.app.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@CrossOrigin //I KNOW IS NOT A GOOD A IDEIA =)/ BUT is a good purpose
@RestController
@RequestMapping("v1/user")
public class UserController {


    @Autowired
    private UserServiceImpl userService;


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Long  createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/update")
    public User updateUser(@Valid @RequestBody User user){
       return userService.updateUser(user);
    }

    @DeleteMapping("/delete")
    public void deleteUser(Long userID) {
        userService.deleteUser(userID);
    }

    @GetMapping("/byID/{userID}")
    public User getUserByID(@Valid @PathVariable Long userID){
        return userService.getUserById(userID);
    }

    @GetMapping("/byUserName/{userName}")
    public User getByUserName(@Valid @PathVariable String userName){
        return userService.getByUserName(userName);
    }

}
