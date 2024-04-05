package com.ocado.basket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ReadJsonTest {

    @Test
    void readConfig() throws FileNotFoundException {
        Map<String, List<String>> config1 = new HashMap<>();

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        list1.add("In-store pick-up");
        list2.add("Next day shipping");
        list2.add("Same day delivery");

        config1.put("Sole - Dover, Whole, Fresh", list1);
        config1.put("Sugar - Cubes", list2);

        Map<String, List<String>> config2 = ReadJson.readConfig("src/test/resources/mini-test-config.json");

        Assertions.assertEquals(config1, config2);
    }

    @Test
    void readBasket() throws FileNotFoundException {
        List<String> basket1 = new ArrayList<>();
        basket1.add("Cocoa Butter");
        basket1.add("Tart - Raisin And Pecan");
        basket1.add("Table Cloth 54x72 White");

        List<String> basket2 = ReadJson.readBasket("src/test/resources/mini-test-basket.json");

        Assertions.assertEquals(basket1, basket2);
    }
}