package com.ocado.basket;
import lombok.Getter;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class BasketSplitter {
    private final Map<String, List<String>> config;
    private final MapOperations<String, String> helper = new MapOperations<>();
    public BasketSplitter(String absolutePathToConfigFile) throws FileNotFoundException {
        this.config = ReadJson.readConfig(absolutePathToConfigFile);
    }

    public Map<String, List<String>> split(List<String> items) {
        Map<String, List<String>> itemsMap = new HashMap<>();
        Map<String, List<String>> result = new HashMap<>();

        for(String item : items) {
            itemsMap.put(item, config.get(item));
        }

        Map<String, List<String>> transportMap = helper.reverseMap(itemsMap);

        while(!transportMap.isEmpty()) {
            String maxTransport = helper.findLongestItemList(transportMap);
            List<String> maxItemList = new ArrayList<>(transportMap.get(maxTransport));
            result.put(maxTransport, maxItemList);
            helper.deleteItems(transportMap, maxTransport, config);
        }

        return result;
    }
}
