package com.stragegic.service.user.mapper;

import com.stragegic.service.user.cmapper.HsqldbMapper;
import com.stragegic.service.user.entity.SUser;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicMapper extends HsqldbMapper<SUser> {

}