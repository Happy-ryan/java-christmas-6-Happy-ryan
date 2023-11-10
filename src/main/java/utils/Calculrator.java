package utils;

import menu.Menu;
import menu.MenuCategory;

import java.util.HashMap;
import java.util.Map;

public class Calculrator {
    private final Map<String, Integer> order;

    Map<String, Integer> mainAndDessertCount = countMainAndDessert();

    public Calculrator(Map<String, Integer> order) {
        this.order = order;
    }

    public int calculateTotalOrderPrice() {
        int totalOrderPrice = 0;
        for (String menu : order.keySet()) {
            totalOrderPrice += order.get(menu) * Menu.valueOf(menu).getPrice();
        }
        return totalOrderPrice;
    }

    public int calculateWeekDayBenefit() {
        int weekdaybenefit = 0;
        weekdaybenefit += mainAndDessertCount.get("DESSERT") * 2023;
        return weekdaybenefit;
    }

    public int calculateWeekeendBenefit() {
        int weekendbenefit = 0;
        weekendbenefit += mainAndDessertCount.get("MAIN") * 2023;
        return weekendbenefit;
    }

    private Map<String, Integer> countMainAndDessert() {
        mainAndDessertCount = new HashMap<>();
        int MainMenuCount = 0;
        int DessertMenutCount = 0;
        for (String menu : order.keySet()) {
            if (MenuCategory.MAIN.getMenuItems().contains(menu)) {
                MainMenuCount++;
            }
            if (MenuCategory.DESSERT.getMenuItems().contains(menu)) {
                DessertMenutCount++;
            }
        }
        mainAndDessertCount.put("MAIN", MainMenuCount);
        mainAndDessertCount.put("DESSERT", DessertMenutCount);
        return mainAndDessertCount;
    }

}
