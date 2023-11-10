package menu;

import java.util.List;
import java.util.Arrays;

public enum MenuCategory {
    APPETIZER(Arrays.asList("양송이수프", "타파스", "시저샐러드"), 0),
    MAIN(Arrays.asList("티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스타"), 0),
    DESSERT(Arrays.asList("초코케이크", "아이스크림"), 0),
    DRINK(Arrays.asList("제로콜라", "레드와인", "샴페인"), 0);

    private final List<String> menuItems;
    private int count;

    MenuCategory(List<String> menuItems, int count) {
        this.menuItems = menuItems;
        this.count = count;
    }

    public List<String> getMenuItems() {
        return menuItems;
    }

    public int getCount(){
        return count;
    }

    public void increaseCount(int count) {
        this.count += count;
    }
}

