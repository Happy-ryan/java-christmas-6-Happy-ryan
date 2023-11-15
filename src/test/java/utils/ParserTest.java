package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ParserTest {

    @DisplayName("String -> Map<String, Integer>")
    @Test
    void testParseIntegerList() {
        List<String> stringList = List.of("apple-3", "banana-5", "orange-2");
        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("apple", 3);
        expectedMap.put("banana", 5);
        expectedMap.put("orange", 2);

        Map<String, Integer> resultMap = Parser.parseIntegerList(stringList);

        assertThat(resultMap).isEqualTo(expectedMap);
    }

    @DisplayName("Map<String, Integer> -> String")
    @Test
    void testBuildOrderString() {
        Map<String, Integer> orderMap = new HashMap<>();
        orderMap.put("burger", 2);
        orderMap.put("fries", 1);
        orderMap.put("drink", 3);

        String expectedResult = "burger-2,fries-1,drink-3";

        String result = Parser.buildOrderString(orderMap);

        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("숫자(int) ->  화폐단위(String)")
    @Test
    void testFormatNumberWithThousandsSeparator() {
        int number = 1234567;
        String expectedResult = "1,234,567원";

        String result = Parser.formatNumberWithThousandsSeparator(number);

        assertThat(result).isEqualTo(expectedResult);
    }
}

