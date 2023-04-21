package com.mscourse.hruser.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mscourse.hruser.entities.User;
import com.mscourse.hruser.repositories.UserRepository;

@RestController
@RequestMapping(value = "/api/users")
public class UserResource {
    
    @Autowired 
    private UserRepository repo;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = repo.findById(id).get(); 
        return ResponseEntity.ok().body(user);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> findById(@RequestParam String email) {
        User user = repo.findByEmail(email); 
        return ResponseEntity.ok().body(user);
    }
}
