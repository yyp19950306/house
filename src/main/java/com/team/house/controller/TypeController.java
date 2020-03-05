package com.team.house.controller;

import com.team.house.entity.Type;
import com.team.house.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(value = "*",allowCredentials = "true")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @RequestMapping("/getAllType")
    public List<Type> getAllType() {
        return typeService.getAllType();
    }
}
