package com.stragegic.system.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "ums_admin")
public class UserAdmin {
    @Id
    private Long id;
    private String username;
    private String password;
    private String icon;
    private String email;
    private String nickName;
    private String note;
    private Date createTime;
    private Date loginTime;
    private Integer status;
}
