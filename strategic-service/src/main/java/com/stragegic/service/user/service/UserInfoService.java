package com.stragegic.service.user.service;

import com.stragegic.service.user.mapper.BasicMapper;
import com.stragegic.service.user.entity.SUser;
import com.stragegic.service.user.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {
    @Autowired
    private BasicMapper mapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    public List<SUser> selectAll() {
        List<SUser> userList = mapper.selectAlls();
        return userList;
    }

    public SUser selectById(String id) {
        SUser sUser = userInfoMapper.selectByPrimaryKey(id);
        return sUser;
    }


}
