package com.team.house.service;

import com.team.house.entity.Users;

import java.util.List;

public interface UsersService {

    Integer regUser(Users users);

    Users login(String name, String password);
}
