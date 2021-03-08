package com.stragegic.web.controller.factorypattern.demo;

import com.stragegic.web.controller.factorypattern.patten.Milk;

public class WhiteMilk implements Milk {
    @Override
    public void factory() {
        System.out.println("白色  white");
    }
}
