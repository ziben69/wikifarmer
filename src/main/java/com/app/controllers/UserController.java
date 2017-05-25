package com.app.controllers;

import com.app.entities.AppUser;
import com.app.entities.Role;
import com.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        List<AppUser> allUsers = userRepository.findAll();
        if (!allUsers.isEmpty())
            return ResponseEntity.ok(allUsers);
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findOneAppUser(@PathVariable Long id) {
        AppUser appUser = userRepository.findOne(id);
        if (appUser!=null)
            return ResponseEntity.ok(appUser);
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addOnlyUser(@RequestBody AppUser user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        userRepository.save(user);
        if (Optional.ofNullable(user.getId()).isPresent()) {
            return ResponseEntity.ok(user);
        } else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
