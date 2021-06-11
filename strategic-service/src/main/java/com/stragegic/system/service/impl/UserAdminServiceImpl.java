package com.stragegic.system.service.impl;


import com.stragegic.system.mapper.UserAdminMapper;
import com.stragegic.system.service.UserAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAdminServiceImpl implements UserAdminService {
    @Autowired
    private UserAdminMapper adminMapper;
}
