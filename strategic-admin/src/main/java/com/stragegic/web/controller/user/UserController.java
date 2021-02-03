package com.stragegic.web.controller.user;

import cn.hutool.core.lang.tree.Tree;
import com.stragegic.domain.core.result.Result;
import com.stragegic.service.user.entity.SUser;
import com.stragegic.service.user.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;
import java.util.function.Supplier;

/**
 * @author 15754
 * <p>用户模块控制器</p>
 */

@Api(tags = "用户模块")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/selectAll")
    @ApiOperation(value = "查询所有用户")
    public Result<SUser> selectAll() {
        System.out.println("main函数开始执行");
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("===task start===");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("===task finish===");
            }
        });

        thread.start();
        System.out.println("main函数执行结束");
        return Result.ok();
    }

    public static void main(String[] args)  throws Exception {
        System.out.println("main函数开始执行");
        ExecutorService executor = Executors.newFixedThreadPool(2);
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                System.out.println("===task start===");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("===task finish===");
                return 3;
            }
        }, executor);
        future.thenAccept(e -> System.out.println(e));
        System.out.println("main函数执行结束");
    }

}
