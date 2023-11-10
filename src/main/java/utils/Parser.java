package utils;

import java.text.DecimalFormat;
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

    public static String buildOrderString(Map<String, Integer> orderMap) {
        StringBuilder sb = new StringBuilder();
        for (String menu : orderMap.keySet()) {
            sb.append(menu).append("-").append(orderMap.get(menu)).append(",");
        }
        if (!sb.isEmpty()) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public static String formatNumberWithThousandsSeparator(int number) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(number) + "원";
    }

}
