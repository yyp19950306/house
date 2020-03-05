package com.team.house.controller;

import com.team.house.entity.Street;
import com.team.house.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(value = "*",allowCredentials = "true")
public class StreetController {

    @Autowired
    private StreetService streetService;

    @RequestMapping("/getStreetByDistrictId")
    public List<Street> getStreetByDistrictId(Integer districtId) {
        return streetService.getStreetByDistrictId(districtId);
    }

}
