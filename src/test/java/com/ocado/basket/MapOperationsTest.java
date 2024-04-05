package com.ocado.basket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MapOperationsTest {
    public MapOperations<String, Integer> mapOperations;
    Map<String, List<Integer>> map;

    @BeforeEach
    void beforeEach() {
        mapOperations = new MapOperations<>();
        map = new HashMap<>();

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        list1.add(1);
        list1.add(11);
        list1.add(3);

        list2.add(2);
        list2.add(3);

        map.put("one", list1);
        map.put("two", list2);
    }

    @Test
    void reverseMap() {
        Map<Integer, List<String>> reversedMap = new HashMap<>();
        List<String> one = new ArrayList<>();
        List<String> two = new ArrayList<>();
        List<String> three = new ArrayList<>();
        List<String> eleven = new ArrayList<>();

        one.add("one");
        two.add("two");
        three.add("one");
        three.add("two");
        eleven.add("one");

        reversedMap.put(1, one);
        reversedMap.put(2, two);
        reversedMap.put(3, three);
        reversedMap.put(11, eleven);

        Assertions.assertEquals(reversedMap, mapOperations.reverseMap(map));
    }

    @Test
    void findLongestItemList() {
        Map<Integer, List<String>> reversedMap = mapOperations.reverseMap(map);
        Assertions.assertEquals(3, mapOperations.findLongestItemList(reversedMap));
    }

    @Test
    void deleteItems() {
        Map<Integer, List<String>> mapWithoutOne = new HashMap<>();
        List<String> two = new ArrayList<>();
        List<String> three = new ArrayList<>();

        two.add("two");
        three.add("two");

        mapWithoutOne.put(2, two);
        mapWithoutOne.put(3, three);

        Map<Integer, List<String>> reversedMap = mapOperations.reverseMap(map);
        mapOperations.deleteItems(reversedMap, 1, map);

        Assertions.assertEquals(mapWithoutOne, reversedMap);
    }
}