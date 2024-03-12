package cz.upce.fei.nnpia.cviceni.controllers;

import cz.upce.fei.nnpia.cviceni.AppUser;
import cz.upce.fei.nnpia.cviceni.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class AppUserController {
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/users")
    public String listAll(Model model) {
        List<AppUser> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }

    @GetMapping("/active")
    public ResponseEntity<String> listActive() {
        List<AppUser> activeUsers = userRepo.findByActive(true);

        // Převést seznam aktivních uživatelů na řetězec
        String result = activeUsers.stream()
                .map(user -> user.toString())
                .collect(Collectors.joining(", "));

        return ResponseEntity.ok(result);
    }

    @GetMapping("/api/v1/app-user/{id}")
    public ResponseEntity<AppUser> getUserById(@PathVariable Integer id) {
        AppUser user = userRepo.findById(id).orElse(null);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/api/v1/app-user")
    public ResponseEntity<AppUser> createUser(@RequestBody AppUser user) {
        user.setCreationDate(new Date());
        user.setUpdateDate(new Date());
        AppUser newUser = userRepo.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @PutMapping("/api/v1/app-user/{id}")
    public ResponseEntity<AppUser> updateUser(@PathVariable Integer id, @RequestBody AppUser user) {
        AppUser existingUser = userRepo.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            existingUser.setActive(user.isActive());
            existingUser.setUpdateDate(new Date());

            AppUser updatedUser = userRepo.save(existingUser);
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/api/v1/app-user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        Optional<AppUser> optionalExistingUser = userRepo.findById(id);
        if (optionalExistingUser.isPresent()) {
            userRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
