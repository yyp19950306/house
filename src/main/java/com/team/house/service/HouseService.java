package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.House;
import com.team.house.util.HouseCondition;
import com.team.house.util.PageParameter;

public interface HouseService {

    Integer addHouse(House house);

    PageInfo<House> getHouseByUserId(PageParameter pageParameter, Integer userId);

    Integer deleteHouse(String id);

    PageInfo<House> getHouseByCondition(HouseCondition houseCondition);
}
