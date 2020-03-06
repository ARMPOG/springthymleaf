package com.example.springmvcthymleaf.controller;

import com.example.springmvcthymleaf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {

    private List<String> acceptContentType = Arrays.asList("image/jpeg", "image/png");

    @GetMapping("/")
    public String mainPage(ModelMap map) {
        List<User> users = Arrays.asList(new User(1, "Armen", "Poghosyan"),
                new User(2, "Benji", "Musheghyan"));
        map.addAttribute("users", users);
        map.addAttribute("user", new User());
        return "index";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        System.out.println(id);
        return "redirect:/";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user,
                          @RequestParam("picture") MultipartFile[] multipartFiles) {
        for (MultipartFile multipartFile : multipartFiles) {
            if (!acceptContentType.contains(multipartFile.getContentType())) {
                System.out.println("invalid content type" + multipartFile.getContentType());
            } else {
                System.out.println(multipartFile.getContentType());
                System.out.println(multipartFile.getOriginalFilename());
            }
        }
        System.out.println(user);

        return "redirect:/";
    }
}


