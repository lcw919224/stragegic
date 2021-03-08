package com.stragegic.service.user.service;

import com.stragegic.service.user.mapper.BasicMapper;
import com.stragegic.service.user.entity.SUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {
    @Autowired
    private BasicMapper mapper;

    public List<SUser> selectAll() {
        List<SUser> userList = mapper.selectAlls();
        return userList;
    }
}
