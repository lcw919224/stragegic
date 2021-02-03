package com.stragegic.web.controller.FactoryPattern.demo;

import com.stragegic.web.controller.FactoryPattern.patten.Milk;

public class BlackMilk implements Milk {
    @Override
    public void factory() {
        System.out.println("黑色 black");
    }
}
