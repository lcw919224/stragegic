package com.stragegic.web.controller.user;

import com.stragegic.domain.core.result.Result;
import com.stragegic.jm.entity.SlaveSUser;
import com.stragegic.jm.service.SlaveUserInfoService;
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

@Api(tags = "几米用户模块")
@RestController
@RequestMapping("/api/jmuser")
public class JmUserController {

    @Autowired
    private SlaveUserInfoService userInfoService;

    @PostMapping("/selectAll")
    @ApiOperation(value = "查询所有用户")
    public Result<List<SlaveSUser>> selectAll() {
        List<SlaveSUser> sUsers = userInfoService.selectAll();
        return Result.ok(sUsers);
    }


}
