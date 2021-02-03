package com.stragegic.web.controller.FactoryPattern.test;

import com.stragegic.web.controller.FactoryPattern.factory.MilkFactory;
import com.stragegic.web.controller.FactoryPattern.patten.Milk;

//简单工厂模式
public class MilkTest {
    public static void main(String[] args) {
        //获取工厂
        MilkFactory factory = new MilkFactory();
        //生成对象
        Milk black = factory.getMilk("black");
        Milk white = factory.getMilk("white");
        //调用方法
        black.factory();
        white.factory();
        System.out.println(black);
        System.out.println(white);
    }
}
