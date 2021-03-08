package com.stragegic.oss.upload.entity;

import lombok.Data;

import javax.persistence.Id;

@Data
public class User {
    @Id
    private Long id;

    private String name;

    private String tel;

}
