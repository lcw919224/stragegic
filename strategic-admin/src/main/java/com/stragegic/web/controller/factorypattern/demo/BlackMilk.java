package com.stragegic.web.controller.factorypattern.demo;

import com.stragegic.web.controller.factorypattern.patten.Milk;

public class BlackMilk implements Milk {
    @Override
    public void factory() {
        System.out.println("黑色 black");
    }
}
