package com.team.house.controller;

import com.team.house.entity.District;
import com.team.house.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(value = "*",allowCredentials = "true")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @RequestMapping("/getAllDistrict")
    public List<District> getAllDistrict() {
        return districtService.getAllDistrict();
    }
}
