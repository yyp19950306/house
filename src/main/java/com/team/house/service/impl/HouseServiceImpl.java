package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.House;
import com.team.house.mapper.HouseMapper;
import com.team.house.service.HouseService;
import com.team.house.util.HouseCondition;
import com.team.house.util.PageParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired(required = false)
    private HouseMapper houseMapper;

    @Override
    public Integer addHouse(House house) {
        return houseMapper.insertSelective(house);
    }

    @Override
    public PageInfo<House> getHouseByUserId(PageParameter pageParameter, Integer userId) {
        PageHelper.startPage(pageParameter.getPageNum(), pageParameter.getPageSize());
        List<House> list = houseMapper.getHouseByUserId(userId);
        return new PageInfo<>(list);
    }

    @Override
    public Integer deleteHouse(String id) {
        return houseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageInfo<House> getHouseByCondition(HouseCondition houseCondition) {
        PageHelper.startPage(houseCondition.getPageNum(), houseCondition.getPageSize());
        List<House> list = houseMapper.getHouseByCondition(houseCondition);
        return new PageInfo<>(list);
    }
}
