package com.stackroute.controller;

import com.stackroute.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class UserController {

    @RequestMapping("/")
    public String returnMessage() {
        return "index";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView userLogin(HttpServletRequest request, HttpServletResponse response)
    {
        String username =request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("display");
        modelAndView.addObject("username", user.getUsername());

        return modelAndView;
    }

}
