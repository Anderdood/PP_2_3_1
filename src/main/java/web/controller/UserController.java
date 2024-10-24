package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "userList";
    }

    @PostMapping("/users/add")
    public String addUser(@RequestParam String name, @RequestParam String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userService.save(user);
        return "redirect:/users";
    }

    @PostMapping("/users/update")
    public String updateUser(@RequestParam Long id, @RequestParam String name, @RequestParam String email) {
        User user = userService.findById(id);
        if (user != null) {
            user.setName(name);
            user.setEmail(email);
            userService.update(user);
        }
        return "redirect:/users";
    }

    @PostMapping("/users/delete")
    public String deleteUser(@RequestParam Long id) {
        userService.delete(id);
        return "redirect:/users";
    }

}
