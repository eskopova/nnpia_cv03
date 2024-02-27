package cz.upce.fei.nnpia.cviceni;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {
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
}
