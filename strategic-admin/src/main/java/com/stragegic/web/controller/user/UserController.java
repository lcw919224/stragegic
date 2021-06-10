package com.stragegic.web.controller.user;

import com.stragegic.domain.core.result.Result;
import com.stragegic.service.user.entity.SUser;
import com.stragegic.service.user.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 15754
 * <p>用户模块控制器</p>
 */

@Api(tags = "用户模块")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/selectAll")
    @ApiOperation(value = "查询所有用户")
    public Result<List<SUser>> selectAll() {
        List<SUser> sUsers = userInfoService.selectAll();
        return Result.ok(sUsers);
    }

    @PostMapping("/demo")
    @ApiOperation(value = "测试")
    public void  demo() {
        System.out.println();
    }

}
