package utils;

import amount.Amount;
import event.Event;
import menu.Menu;
import menu.MenuCategory;

import java.util.HashMap;
import java.util.Map;

public class Calculrator {
    private final int day;
    private final Map<String, Integer> order;

    Map<String, Integer> mainAndDessertCount;

    public Calculrator(int day, Map<String, Integer> order) {
        System.out.println("생성돼?");
        this.order = order;
        this.day = day;
        this.mainAndDessertCount = new HashMap<>();
        countMainAndDessert();
    }

    public int calculateTotalOrderPrice() {
        for (String menu : order.keySet()) {
            Amount.TOTAL_ORDER.increaseAmount(order.get(menu) * Menu.valueOf(menu).getPrice());
        }
        return Amount.TOTAL_ORDER.getValue();
    }

    public Map<String, Integer> calculateBenefitByDate() {
        Map<String, Integer> benefitByDate = new HashMap<>();
        int totalBenefitAmount = 0;
        if (Event.CHRISTMAS.getDates().contains(day)) {
            int christmasbenefit = calculateChristmasBebefit();
            totalBenefitAmount += christmasbenefit;
            benefitByDate.put(Event.CHRISTMAS.getType(), christmasbenefit);
        }
        if (Event.WEEKDAY.getDates().contains(day)) {
            int weekdaybenefit = calculateWeekDayBenefit();
            totalBenefitAmount += weekdaybenefit;
            benefitByDate.put(Event.WEEKDAY.getType(), weekdaybenefit);
        }
        if (Event.WEEKEND.getDates().contains(day)) {
            int weekendbenefit = calculateWeekeendBenefit();
            totalBenefitAmount += weekendbenefit;
            benefitByDate.put(Event.WEEKEND.getType(), weekendbenefit);
        }
        if (Event.SPECIAL.getDates().contains(day)) {
            int specialbenefit = calculateSpecialBenefit();
            totalBenefitAmount += specialbenefit;
            benefitByDate.put(Event.SPECIAL.getType(), specialbenefit);
        }
        if (Amount.TOTAL_ORDER.getValue() >= 120000) {
            int giftbenefit = calculateGiftBenefit();
            totalBenefitAmount += giftbenefit;
            benefitByDate.put(Event.GIFT.getType(), giftbenefit);
        }
        Amount.TOTAL_BENEFIT.increaseAmount(totalBenefitAmount);
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

    public int calculateGiftBenefit() {
        return 25000;
    }

    private int calculateSpecialBenefit(){
        return 1000;
    }

    private Map<String, Integer> countMainAndDessert() {
        int MainMenuCount = 0;
        int DessertMenutCount = 0;
        for (String menu : order.keySet()) {
            if (MenuCategory.MAIN.getMenuItems().contains(menu)) {
                MainMenuCount += order.get(menu);
            }
            if (MenuCategory.DESSERT.getMenuItems().contains(menu)) {
                DessertMenutCount += order.get(menu);
            }
        }
        mainAndDessertCount.put("MAIN", MainMenuCount);
        mainAndDessertCount.put("DESSERT", DessertMenutCount);
        return mainAndDessertCount;
    }

}
