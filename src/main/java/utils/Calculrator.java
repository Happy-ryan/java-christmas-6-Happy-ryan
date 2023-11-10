package utils;

import event.Event;
import menu.Menu;
import menu.MenuCategory;

import java.util.HashMap;
import java.util.Map;

public class Calculrator {
    private final int day;
    private final Map<String, Integer> order;

    Map<String, Integer> mainAndDessertCount = countMainAndDessert();

    public Calculrator(int day, Map<String, Integer> order) {
        this.order = order;
        this.day = day;
    }

    public int calculateTotalOrderPrice() {
        int totalOrderPrice = 0;
        for (String menu : order.keySet()) {
            totalOrderPrice += order.get(menu) * Menu.valueOf(menu).getPrice();
        }
        return totalOrderPrice;
    }

    public Map<String, Integer> calculateBenefitByDate() {
        Map<String, Integer> benefitByDate = new HashMap<>();
        if (Event.CHRISTMAS.getDates().contains(day)) {
            int christmasbenefit = calculateChristmasBebefit();
            benefitByDate.put(Event.CHRISTMAS.getType(), christmasbenefit);
        }
        if (Event.WEEKDAY.getDates().contains(day)) {
            int weekdaybenefit = calculateWeekDayBenefit();
            benefitByDate.put(Event.WEEKDAY.getType(), weekdaybenefit);
        }
        if (Event.WEEKEND.getDates().contains(day)) {
            int weekendbenefit = calculateWeekeendBenefit();
            benefitByDate.put(Event.WEEKEND.getType(), weekendbenefit);
        }
        if (Event.SPECIAL.getDates().contains(day)) {
            int specialbenefit = 1000;
            benefitByDate.put(Event.SPECIAL.getType(), specialbenefit);
        }
        if (Event.GIFT.getDates().contains(day)) {
            int giftbenefit = calculateBonusItemBenefit();
            benefitByDate.put(Event.GIFT.getType(), giftbenefit);
        }
        return benefitByDate;
    }

    public int calculateChristmasBebefit() {
        int christmasBenefit = 0;
        christmasBenefit += 1000 + 100 * (day - 1);
        return christmasBenefit;
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

    public int calculateBonusItemBenefit() {
        int totalOrderPrice = calculateTotalOrderPrice();
        if (totalOrderPrice >= 120000) {
            return 25000;
        }
        return 0;
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
