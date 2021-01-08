package com.stragegic.web.controller.user;

import com.stragegic.result.Result;
import com.stragegic.service.user.entity.UserInfo;
import com.stragegic.service.user.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 15754
 * <p>用户模块控制器</p>
 */

@Api("用户模块")
@RestController
@RequestMapping("/api/user")
public class UserController {


    @Autowired
    private UserInfoService userInfoService;


    @PostMapping("/selectAll")
    @ApiOperation(value = "查询所有用户")
    public Result<UserInfo> selectAll() {
        System.out.println(userInfoService);
        return Result.ok();
    }

}
