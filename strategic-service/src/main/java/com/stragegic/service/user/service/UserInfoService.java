package com.stragegic.service.user.service;

import com.stragegic.service.user.entity.SUser;
import com.stragegic.service.user.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoMapper infoMapper;

    public List<SUser> selectAll() {
        return infoMapper.selectAll();
    }
}
