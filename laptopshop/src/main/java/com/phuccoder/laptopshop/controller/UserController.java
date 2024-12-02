package com.phuccoder.laptopshop.controller;

// import java.util.List;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.phuccoder.laptopshop.domain.User;
import com.phuccoder.laptopshop.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String showHelloPage() {
        return "hello";
    }

    @RequestMapping("/admin/user")
    public String getUserPage(Model model) {
        List<User> users = this.userService.getAllUsers();
        model.addAttribute("users", users);
        System.out.println("List users is: " + users);
        return "admin/user/tableuser"; // trang getuser.html
    }

    @RequestMapping("/admin/user/view/{id}")
    public String getUserDetailPage(Model model, @PathVariable long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("id", id);
        return "admin/user/show";
    }

    @RequestMapping("/admin/user/update/{id}")
    public String updateUserDetailPage(Model model, @PathVariable long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("newUser", user);
        model.addAttribute("id", id);
        return "admin/user/update";
    }

    @RequestMapping("/admin/user/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User()); // tạo user
        return "admin/user/create"; // file create.html
    }

    @RequestMapping("/admin/user/update")
    public String getUpdateUserPage(Model model) {
        model.addAttribute("newUser", new User()); // tạo user
        return "admin/user/update"; // file create.html
    }

    // create
    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST) // lưu user
    public String createUserPage(@ModelAttribute("newUser") User phuccoder) {
        System.out.println("Create here " + phuccoder);
        this.userService.saveUser(phuccoder);
        return "redirect:/admin/user"; // trả về url /admin/user
    }

    // update
    @RequestMapping(value = "/admin/user/update", method = RequestMethod.POST)
    public String updateUserPage(@ModelAttribute("newUser") User phuccoder) {
        this.userService.updateUser(phuccoder);
        return "redirect:/admin/user";
    }
}
