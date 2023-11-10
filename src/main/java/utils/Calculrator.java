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

    public Calculrator(int day, Map<String, Integer> order) {
        this.order = order;
        this.day = day;
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
        if (Event.WEEKDAY.getDates().contains(day) && MenuCategory.DESSERT.getCount() > 0) {
            int weekdaybenefit = calculateWeekDayBenefit();
            totalBenefitAmount += weekdaybenefit;
            benefitByDate.put(Event.WEEKDAY.getType(), weekdaybenefit);
        }
        if (Event.WEEKEND.getDates().contains(day) && MenuCategory.MAIN.getCount() > 0) {
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

    private int calculateChristmasBebefit() {
        int christmasBenefit = 0;
        christmasBenefit += 1000 + 100 * (day - 1);
        return christmasBenefit;
    }

    private int calculateWeekDayBenefit() {
        int weekdaybenefit = 0;
        weekdaybenefit += MenuCategory.DESSERT.getCount() * 2023;
        return weekdaybenefit;
    }

    private int calculateWeekeendBenefit() {
        int weekendbenefit = 0;
        weekendbenefit += MenuCategory.MAIN.getCount() * 2023;
        return weekendbenefit;
    }

    private int calculateGiftBenefit() {
        return 25000;
    }

    private int calculateSpecialBenefit() {
        return 1000;
    }

    private void countMainAndDessert() {
        for (String menu : order.keySet()) {
            if (MenuCategory.MAIN.getMenuItems().contains(menu)) {
                MenuCategory.MAIN.increaseCount(order.get(menu));
            }
            if (MenuCategory.DESSERT.getMenuItems().contains(menu)) {
                MenuCategory.DESSERT.increaseCount(order.get(menu));
            }
        }
    }

}
