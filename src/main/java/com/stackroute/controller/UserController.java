package com.stackroute.controller;

import com.stackroute.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;




@Controller
public class UserController {

    @RequestMapping("/")
    public String returnMessage() {

        return "index";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView success(@RequestParam("username")String username, @RequestParam("password")String password, ModelMap map)
    {

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("display");
        modelAndView.addObject("username", user.getUsername());

        return modelAndView;
    }

}
