package utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {
    public static Map<String, Integer> parseIntegerList(List<String> stringList) {
        Map<String, Integer> parsedMap = new HashMap<>();
        for (String str : stringList) {
            List<String> splitStrings = List.of(str.split("-"));
            String key = splitStrings.get(0);
            int value = Integer.parseInt(splitStrings.get(1));
            parsedMap.put(key, value);
        }
        return parsedMap;
    }
}
