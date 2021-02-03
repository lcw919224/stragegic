package com.stragegic.web.controller.FactoryPattern.factory;

import com.stragegic.web.controller.FactoryPattern.demo.BlackMilk;
import com.stragegic.web.controller.FactoryPattern.demo.WhiteMilk;
import com.stragegic.web.controller.FactoryPattern.patten.Milk;

public class MilkFactory {

    public Milk getMilk(String name) {
        if (name == null) {
            return null;
        }
        if ("white".equalsIgnoreCase(name)) {
            return new WhiteMilk();
        } else if ("black".equalsIgnoreCase(name)) {
            return new BlackMilk();
        }
        return null;
    }
}
