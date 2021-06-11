package com.stragegic.web.controller.system;

import com.stragegic.domain.core.result.Result;
import com.stragegic.system.service.UserAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "系统登陆模块")
@RestController
@RequestMapping("/system/")
public class AdminUserController {

    @Autowired
    private UserAdminService userAdminService;

    @RequestMapping("/get")
    @ApiOperation("登陆测试")
    public Result login() {
        System.out.println("登陆测试");
        return Result.ok();
    }
}
