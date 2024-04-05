package com.ocado.basket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapOperations<K, V> {
    public Map<V, List<K>> reverseMap(Map<K, List<V>> map) {
        Map<V, List<K>> reversedMap = new HashMap<>();

        for(Map.Entry<K, List<V>> entry : map.entrySet()) {
            for(V transport : entry.getValue()) {
                if(!reversedMap.containsKey(transport)) {
                    List<K> productList = new ArrayList<>();
                    productList.add(entry.getKey());
                    reversedMap.put(transport, productList);
                } else {
                    reversedMap.get(transport).add(entry.getKey());
                }
            }
        }

        return reversedMap;
    }

    public V findLongestItemList(Map<V, List<K>> transportMap) {
        V maxTransport = null;
        int maxItemNumber = 0;

        for(Map.Entry<V, List<K>> entry : transportMap.entrySet()) {
            if(entry.getValue().size() > maxItemNumber) {
                maxItemNumber = entry.getValue().size();
                maxTransport = entry.getKey();
            }
        }

        return maxTransport;
    }

    public void deleteItems(Map<V, List<K>> transportMap, V transportToDel, Map<K, List<V>> config) {
        List<K> itemsToDel = new ArrayList<>(transportMap.get(transportToDel));
        for(K item : itemsToDel) {
            for(V transport : config.get(item)) {
                transportMap.get(transport).remove(item);

                if(transportMap.get(transport).isEmpty())
                    transportMap.remove(transport);
            }
        }

        transportMap.remove(transportToDel);
    }
}
