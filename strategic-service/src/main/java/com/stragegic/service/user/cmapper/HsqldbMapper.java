package com.stragegic.service.user.cmapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.annotation.RegisterMapper;

import java.util.List;

/**
 * @author lcw
 *
 * <p>
 * 定义通用mapper
 * </p>
 */

@RegisterMapper
public interface HsqldbMapper<T> {

    /**
     * 查询全部结果
     *
     * @return
     */
    @SelectProvider(type = HsqldbProvider.class, method = "dynamicSQL")
    List<T> selectAlls();


    /**
     * 通过id查询
     *
     * @return
     */
    @SelectProvider(type = HsqldbProvider.class, method = "dynamicSQL")
    List<T> getById(@Param("ids") String ids);
}

