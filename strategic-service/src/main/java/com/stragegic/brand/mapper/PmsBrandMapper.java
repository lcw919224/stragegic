package com.stragegic.brand.mapper;

import com.stragegic.brand.entity.PmsBrand;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface PmsBrandMapper extends Mapper<PmsBrand> {

    int deleteByPrimaryKey(Long id);

    int insertSelective(PmsBrand record);

    PmsBrand selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsBrand record);

}