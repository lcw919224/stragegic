package com.stragegic.jm.service;

import com.stragegic.jm.entity.SlaveSUser;
import com.stragegic.jm.mapper.Slavemapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlaveUserInfoService {

    @Autowired
    private Slavemapper infoMapper;

   public List<SlaveSUser> selectAll()
   {
       List<SlaveSUser> sUsers = infoMapper.selectAll();
       return sUsers;
    }
}
