package com.stragegic.web.controller.factorypattern.factory;

import com.stragegic.web.controller.factorypattern.demo.BlackMilk;
import com.stragegic.web.controller.factorypattern.demo.WhiteMilk;
import com.stragegic.web.controller.factorypattern.patten.Milk;

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
