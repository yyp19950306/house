package com.team.house.controller;

import com.team.house.entity.Users;
import com.team.house.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(value = "*",allowCredentials = "true")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping("/regUsers")
    public String regUsers(Users users) {
        Integer temp = usersService.regUser(users);
        return "{\"result\":" + temp + "}";
    }

    @RequestMapping("/login")
    public String login(String name, String password, HttpSession session) {
        Users users = usersService.login(name, password);
        if (users != null) {
            session.setAttribute("userInfo", users);
            session.setMaxInactiveInterval(36000);
            return "{\"result\":1}";
        } else {
            return "{\"result\":0}";
        }
    }

}
