package com.stragegic.service.user.mapper;

import com.stragegic.service.user.entity.SUser;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

@Repository
public interface UserInfoMapper extends BaseMapper<SUser> {

}
