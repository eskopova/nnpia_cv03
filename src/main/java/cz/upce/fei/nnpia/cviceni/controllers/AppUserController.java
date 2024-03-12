package cz.upce.fei.nnpia.cviceni.controllers;

import cz.upce.fei.nnpia.cviceni.AppUser;
import cz.upce.fei.nnpia.cviceni.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
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
    public String listActive(Model model) {
        List<AppUser> activeUsers = userRepo.findByActive(true);

        // Převést seznam aktivních uživatelů na řetězec
        String result = activeUsers.stream()
                .map(user -> user.toString())
                .collect(Collectors.joining(", "));

        return result;
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
}
