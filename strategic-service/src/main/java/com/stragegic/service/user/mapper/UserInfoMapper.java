package com.stragegic.service.user.mapper;

import com.stragegic.service.user.entity.UserInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;


@Repository
public interface UserInfoMapper extends Mapper<UserInfo> {
}
