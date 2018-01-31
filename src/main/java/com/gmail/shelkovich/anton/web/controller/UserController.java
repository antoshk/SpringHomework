package com.gmail.shelkovich.anton.web.controller;

import com.gmail.shelkovich.anton.service.UserService;
import com.gmail.shelkovich.anton.service.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/users")
public class UserController {

    @Autowired
    private UserValidator userValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(userValidator);
    }

    @Autowired
    private UserService userService;

    @GetMapping()
    public String getUsers(ModelMap model){
        model.addAttribute("users", userService.getAll());
        return "users";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addUser(ModelMap model){
        model.addAttribute("newUser", new UserDTO());
        return "addUser";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveUser(@Valid @ModelAttribute("newUser") UserDTO newUser, BindingResult result){
        if(result.hasErrors()){
            return "addUser";
        }
        userService.addUser(newUser);
        return "redirect:/admin/users";
    }

    @RequestMapping(value = "/{userId}/delete", method = RequestMethod.POST)
    public String deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
        return "redirect:/admin/users";
    }



}
