package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/")
    public String getUserByID(@RequestParam Long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "show";
    }

   /* @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "show";
    }*/

    @GetMapping("/new")
    public String showSignUpForm(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:users";
    }

    //    @GetMapping("/{id}/edit")
//    public String showUpdateForm(@PathVariable Long id, Model model) {
//        model.addAttribute("user", userService.getUser(id));
//        return "edit";
//    }
    @GetMapping("/edit")
    public String showUpdateForm(@RequestParam Long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }

//    @PatchMapping("/{id}")
//    public String updateUser(@ModelAttribute("user") User user, @PathVariable Long id) {
//        userService.updateUser(id, user);
//        return "redirect:/users";
//    }

    @PatchMapping("/")
    public String updateUser(@RequestParam Long id, @ModelAttribute("user") User user) {

        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/")
    public String deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

}
