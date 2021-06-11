package com.stragegic.system.mapper;

import com.stragegic.system.entity.UserAdmin;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserAdminMapper extends Mapper<UserAdmin> {
}
