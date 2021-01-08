package com.stragegic.service.user.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户数据库映射对象
 *
 * @author 15754
 */
@Data
@Table(name = "s_user")
public class SUser {
    @Id
    private Long id;

    private String name;

    private String tel;
}
