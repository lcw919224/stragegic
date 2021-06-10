package com.stragegic.service.user.mapper;

import com.stragegic.service.user.entity.PmsBrand;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PmsBrandMapper {

    int deleteByPrimaryKey(Long id);

    int insertSelective(PmsBrand record);

    PmsBrand selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsBrand record);

}