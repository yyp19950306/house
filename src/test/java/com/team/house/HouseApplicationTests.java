package com.team.house;

import com.team.house.entity.District;
import com.team.house.entity.DistrictExample;
import com.team.house.entity.House;
import com.team.house.entity.HouseExample;
import com.team.house.mapper.DistrictMapper;
import com.team.house.mapper.HouseMapper;
import com.team.house.service.UsersService;
import com.team.house.util.MD5Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HouseApplicationTests {

    @Autowired(required = false)
    private HouseMapper houseMapper;


    @Test
    public void contextLoads() {
        System.out.println(MD5Utils.md5Encrypt(null));
    }

}
