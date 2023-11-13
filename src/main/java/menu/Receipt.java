package menu;

import java.util.HashMap;
import java.util.Map;

public class Receipt {
    int totalPrice = 0;
    Map<Menu, Integer> orderedMenu;
    Map<MenuCategory, Integer> orderedMenuCategory;

    public Receipt(Map<String, Integer> order) {
        this.orderedMenu = new HashMap<>();
        this.orderedMenuCategory = new HashMap<>();
        for (Map.Entry<String, Integer> m : order.entrySet()) {
            addMenu(Menu.valueOf(m.getKey()), m.getValue());
        }
    }

    public void addMenu(Menu menu, int count) {
        totalPrice += menu.getPrice() * count;
        if (!orderedMenu.containsKey(menu)) {
            orderedMenu.put(menu, 0);
        }
        orderedMenu.put(menu, orderedMenu.get(menu) + count);
        MenuCategory category = MenuCategory.getMenuCategory(menu);
        if (!orderedMenuCategory.containsKey(category)) {
            orderedMenuCategory.put(category, 0);
        }
        orderedMenuCategory.put(category, orderedMenuCategory.get(category) + count);
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getAppetizerCount() {
        return orderedMenuCategory.get(MenuCategory.APPETIZER);
    }

    public int getMainCount() {
        return orderedMenuCategory.get(MenuCategory.MAIN);
    }

    public int getDessertCount() {
        return orderedMenuCategory.get(MenuCategory.DESSERT);
    }

    public int getDrinkCount() {
        return orderedMenuCategory.get(MenuCategory.DRINK);
    }
}
