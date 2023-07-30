package com.mb.transfer.TransferToBoot.controller;

import com.mb.transfer.TransferToBoot.models.User;
import com.mb.transfer.TransferToBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String printWelcome(Model model) {
        List<String> messages = new ArrayList<>();

        messages.add("Hello! To display all users click:");
        model.addAttribute("messages", messages);
        return "index";
    }

    @GetMapping("/users")
    public String showAllUsers(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("userList", userList);
        return "users";
    }

    @GetMapping("/users/{id}")
    public String showUser(@PathVariable int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "showUser";
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.removeUserById(id);
        return "redirect:/users";
    }

    @GetMapping("users/new")
    public String newUser(@ModelAttribute User user) {
        return "new";
    }

    @PostMapping("users")
    public String create(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("users/{id}/edit")
    public String edit(Model model, @PathVariable int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @PatchMapping("users/{id}")
    public String updateUser(@ModelAttribute User user, @PathVariable int id) {
        userService.updateUser(id, user.getName(), user.getLastName(), user.getAge());
        return "redirect:/users";
    }
}