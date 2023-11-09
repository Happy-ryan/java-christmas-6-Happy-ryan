package utils;

import menu.Menu;

import java.text.DecimalFormat;
import java.util.Map;

public class Calculrator {

    private final Map<String, Integer> order;

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
}
