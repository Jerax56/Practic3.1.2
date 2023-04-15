package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @GetMapping(value = "/addNewUser")
    public String addNewUser(Model model) {
        model.addAttribute("newUser", new User());
        return "user-info";
    }

    @PostMapping(value = "/saveUser")
    public String saveUser(@ModelAttribute("newUser") User user) {
        if (user.getID() == 0) {
            userService.saveUsers(user);
        } else {
            userService.updateUser(user);
        }
        return "redirect:/";
    }

    @GetMapping(value = "/updateUser")
    public String updateEmployee(@RequestParam("ID") int ID, Model model) {
        model.addAttribute("newUser", userService.getUser(ID));
        return "user-info";
    }

    @PatchMapping(value = "/updateUser")
    public String updateUser(@RequestParam("ID") int ID, @RequestBody User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @DeleteMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam("ID") int ID) {
        userService.deleteUser(ID);
        return "redirect:/";
    }
}