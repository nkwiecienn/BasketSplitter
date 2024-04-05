package com.ocado.basket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

class BasketSplitterTest {

    @Test
    void split() throws FileNotFoundException {
        BasketSplitter basketSplitter = new BasketSplitter("src/test/resources/config-example.json");
        List<String> basketList = ReadJson.readBasket("src/test/resources/basket-example.json");
        Map<String, List<String>> expected = ReadJson.readConfig("src/test/resources/result-example.json");
        Map<String, List<String>> result = basketSplitter.split(basketList);

        Assertions.assertEquals(expected.keySet(), result.keySet());

        for(Map.Entry<String, List<String>> entry : expected.entrySet()) {
            List<String> resultList = result.get(entry.getKey());

            Assertions.assertEquals(resultList.size(), entry.getValue().size());
            Assertions.assertTrue(resultList.containsAll(entry.getValue()));
            Assertions.assertTrue(entry.getValue().containsAll(resultList));
        }
    }
}