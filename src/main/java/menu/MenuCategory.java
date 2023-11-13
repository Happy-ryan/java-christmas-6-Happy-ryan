package menu;

import java.util.List;
import java.util.Arrays;

public enum MenuCategory {
    UNKNOWN("unknown", Arrays.asList()),
    APPETIZER("애피타이저", Arrays.asList(Menu.양송이수프, Menu.타파스, Menu.시저샐러드)),
    MAIN("메인", Arrays.asList(Menu.티본스테이크, Menu.바비큐립, Menu.해산물파스타, Menu.크리스마스파스타)),
    DESSERT("디저트", Arrays.asList(Menu.초코케이크, Menu.아이스크림)),
    DRINK("음료", Arrays.asList(Menu.제로콜라, Menu.레드와인, Menu.샴페인));

    private final String type;
    private final List<Menu> menuItems;

    MenuCategory(String type, List<Menu> menuItems) {
        this.type = type;
        this.menuItems = menuItems;
    }

    public String getType() {
        return type;
    }

    public List<Menu> getMenuItems() {
        return menuItems;
    }

    public static MenuCategory getMenuCategory(Menu menu) {
        if (APPETIZER.getMenuItems().contains(menu)) {
            return APPETIZER;
        }
        if (MAIN.getMenuItems().contains(menu)) {
            return MAIN;
        }
        if (DESSERT.getMenuItems().contains(menu)) {
            return DESSERT;
        }
        if (DRINK.getMenuItems().contains(menu)) {
            return DRINK;
        }
        return UNKNOWN;
    }
}

