package view;

import camp.nextstep.edu.missionutils.Console;
import menu.Menu;
import menu.MenuCategory;
import utils.Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InputView {

    public static int readDate() {
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

    public static Map<String, Integer> readOrder() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        while (true) {
            try {
                Map<String, Integer> order = inputOrder();
                return order;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int inputDate() {
        String input = Console.readLine();
        validateNumber(input);
        return Integer.parseInt(input);
    }

    private static Map<String, Integer> inputOrder() {
        List<String> input = new ArrayList<>(List.of(Console.readLine().split(",")));
        validateOrderFormat(input);
        validateCheckForDuplicates(input);

        Map<String, Integer> menuAndQuantity = Parser.parseIntegerList(input);
        validateMenu(menuAndQuantity);
        validateQuantity(menuAndQuantity);
        validateOrderWithBeverageOnly(menuAndQuantity);

        return menuAndQuantity;
    }

    private static void validateNumber(String day) {
        if (!day.matches("(3[01]|[12][0-9]|[1-9])")) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    private static void validateOrderFormat(List<String> menuAndQuantity) {
        for (String meneAndPrice : menuAndQuantity) {
            if (!meneAndPrice.matches("^([가-힣]+-\\d+)")) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }

    private static void validateCheckForDuplicates(List<String> menuAndQuantity) {
        int originalSize = menuAndQuantity.size();
        int parsedListSize = Parser.parseIntegerList(menuAndQuantity).size();
        if (originalSize != parsedListSize) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static void validateMenu(Map<String, Integer> menuAndQuantity) {
        for (String menu : menuAndQuantity.keySet()) {
            if (!Menu.contains(menu)) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }

    private static void validateQuantity(Map<String, Integer> menuAndQuantity) {
        int totalQuantity = 0;
        for (String menu : menuAndQuantity.keySet()) {
            if (menuAndQuantity.get(menu) <= 0) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
            totalQuantity += menuAndQuantity.get(menu);
        }
        if (totalQuantity > 20) {
            throw new IllegalArgumentException("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다");
        }
    }

    private static void validateOrderWithBeverageOnly(Map<String, Integer> menuAndQuantity) {
        boolean onlyDrinkFlag = checkIfOnlyDrinks(menuAndQuantity);
        if (onlyDrinkFlag) {
            throw new IllegalArgumentException("[ERROR] 음료만 주문 시, 주문할 수 없습니다.");
        }
    }

    private static boolean checkIfOnlyDrinks(Map<String, Integer> menuAndQuantity) {
        for (String menu : menuAndQuantity.keySet()) {
            if (!MenuCategory.DRINK.getMenuItems().contains(Menu.valueOf(menu))) {
                return false;
            }
        }
        return true;
    }

}
