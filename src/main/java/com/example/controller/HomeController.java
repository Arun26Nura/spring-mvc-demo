package com.example.controller;

import com.example.model.AccountDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String baseController(){
        return "redirect:home";
    }

    @GetMapping("/home")
    public String homeController(){
        return "homeView";
    }

    @PostMapping("/create-account")
   public String createAccount(@ModelAttribute(name ="employee")AccountDto account, Model model){
   // public String createAccount(HttpServletRequest request, HttpServletResponse response, Model model){

       model.addAttribute("account", account);
        return "accountSummary";
    }
}
