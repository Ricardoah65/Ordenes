package com.sistema.ordenes.controller;

import com.sistema.ordenes.model.User;
import com.sistema.ordenes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveUser(@RequestBody User user){
        if (user.getIdUser() == null || !this.userService.exist(user.getIdUser())){
            this.userService.saveUser(user);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id){
        return ResponseEntity.ok(this.userService.findById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(this.userService.findAll());
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<User> getByEmail(@PathVariable String email){
        return ResponseEntity.ok(this.userService.findByEmail(email));
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Optional<Void>> deleteById(@PathVariable Long id){
        if (this.userService.exist(id)){
            ResponseEntity.ok(this.userService.deleteById(id));
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable  Long id,@RequestBody User user){
        return ResponseEntity.ok(this.userService.update(id, user));
    }



}
