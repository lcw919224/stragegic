package com.stragegic.web.controller.FactoryPattern.demo;

import com.stragegic.web.controller.FactoryPattern.patten.Milk;

public class WhiteMilk implements Milk {
    @Override
    public void factory() {
        System.out.println("白色  white");
    }
}
