package menu;

import java.util.HashMap;
import java.util.Map;

public class Receipt {
    private int totalPrice = 0;
    private Map<Menu, Integer> orderedMenu;
    private Map<MenuCategory, Integer> orderedMenuCategory;

    public Receipt(Map<String, Integer> order) {
        this.orderedMenu = new HashMap<>();
        this.orderedMenuCategory = new HashMap<>();
        for (Map.Entry<String, Integer> m : order.entrySet()) {
            addMenu(Menu.valueOf(m.getKey()), m.getValue());
        }
    }

    private void addMenu(Menu menu, int count) {
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
        if (orderedMenuCategory.containsKey(MenuCategory.APPETIZER)) {
            return orderedMenuCategory.get(MenuCategory.APPETIZER);
        }
        return 0;
    }

    public int getMainCount() {
        if (orderedMenuCategory.containsKey(MenuCategory.MAIN)) {
            return orderedMenuCategory.get(MenuCategory.MAIN);
        }
        return 0;
    }

    public int getDessertCount() {
        if (orderedMenuCategory.containsKey(MenuCategory.DESSERT)) {
            return orderedMenuCategory.get(MenuCategory.DESSERT);
        }
        return 0;
    }

    public int getDrinkCount() {
        if (orderedMenuCategory.containsKey(MenuCategory.DRINK)) {
            return orderedMenuCategory.get(MenuCategory.DRINK);
        }
        return 0;
    }
}
