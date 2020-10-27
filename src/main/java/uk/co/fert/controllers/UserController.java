package uk.co.fert.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uk.co.fert.dao.User;
import uk.co.fert.services.UserDetailsServiceImpl;


@Controller
public class UserController {
    @Autowired
    UserDetailsServiceImpl userService;

    @GetMapping("/admin/home")
    @Secured("ADMIN")
    @ResponseBody
    public String viewAdminHome() {
        userService.getAllUsers();
        return "adminhome";
    }

    @PostMapping("/createUser")
    @Secured("ADMIN")
    @ResponseBody
    public void create(@RequestBody @ModelAttribute("user") User user) {
        userService.save(user);
    }


    @PatchMapping("/updateUserRole")
    @Secured("ADMIN")
    @ResponseBody
    public void update(@RequestBody User user) { userService.save(user);
    }

    @GetMapping("/findUser")
    @Secured({"ROLE_STATION", "ROLE_REVENUE"})
    @ResponseBody
    public User find(@RequestParam(name = "id") int id) {
        return userService.find(id);
    }
}
