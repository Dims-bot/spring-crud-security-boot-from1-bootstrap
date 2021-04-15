package com.javamentor.springcrudsecuritybootfrom1.controllers;

import com.javamentor.springcrudsecuritybootfrom1.Model.User;
import com.javamentor.springcrudsecuritybootfrom1.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class UserController {

    UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

        @GetMapping("/login")
    public String loginError (Model model) {
        model.addAttribute("loginError", true);

        return "login";
    }

    @GetMapping("/users/admin")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());

        return "getAllUsers";
    }

    @PatchMapping("/users/admin/{id}")
    public String updateUserById(@ModelAttribute("user") @Valid User user,
                                 BindingResult bindingResult, @PathVariable("id") Long id) {
        if (bindingResult.hasErrors())
            return "edit";

        userService.updateUser(id, user);
        return "edit";
    }

    @GetMapping("/users/admin/{id}/edit")
    public String editUserById(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @GetMapping("/users/admin/{id}")
    public String getUserById(@PathVariable("id") Long id, Model model) {

        model.addAttribute("user", userService.getUserById(id));

        return "getUserByID";
    }

    @GetMapping("/users/admin/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());

        return "newUser";
    }

    @PostMapping("/users/admin")
    public String createNewUser(@ModelAttribute("user") @Valid User user,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "newUser";
        userService.save(user);

        return "redirect:/users/admin";
    }
    @GetMapping("/users/user")
    public String getUserByLogin(ModelMap modelMap, Principal principal) {
        User user = userService.getUserByUsername(principal.getName());

        modelMap.addAttribute("user", userService.getUserByUsername(principal.getName()));
        modelMap.addAttribute("userRolesPrefixFree", user.getUserRolesPrefixFree());

        return "user";
    }

    @DeleteMapping("/users/admin/{id}")
    public String deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users/admin";
    }
}


