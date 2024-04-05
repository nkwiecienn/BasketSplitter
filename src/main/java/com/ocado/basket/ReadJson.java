package com.ocado.basket;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadJson {
    public static Map<String, List<String>> readConfig(String absolutePathToConfigFile) throws FileNotFoundException
    {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePathToConfigFile));

        Gson gson = new Gson();

        return gson.fromJson(bufferedReader, HashMap.class);
    }

    public static List<String> readBasket(String absolutePathToConfigFile) throws FileNotFoundException
    {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePathToConfigFile));

        Gson gson = new Gson();

        return gson.fromJson(bufferedReader, List.class);
    }
}
