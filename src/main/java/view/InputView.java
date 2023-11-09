package view;

import camp.nextstep.edu.missionutils.Console;
import utils.Parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputView {

    public int readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        while (true) {
            try {
                int date = inputDate();
                return date;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Map<String, Integer> readOrder() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        while (true) {
            try {
                List<String> input = new ArrayList<>(List.of(Console.readLine().split(",")));
                validateOrderFormat(input);
                Map<String, Integer> menuAndPrice = Parser.parseIntegerList(input);
                return menuAndPrice;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int inputDate() {
        String day = Console.readLine();
        validateNumber(day);
        return Integer.parseInt(day);
    }

    private void validateNumber(String day) {
        if (!day.matches("(3[01]|[12][0-9]|[1-9])")) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    private void validateOrderFormat(List<String> menuAndPrices) {
        for (String meneAndPrice : menuAndPrices) {
            if (!meneAndPrice.matches("^([가-힣]+-\\d+)")) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }
}
