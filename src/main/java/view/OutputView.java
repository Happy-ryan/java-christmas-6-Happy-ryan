package view;

import amount.Amount;
import inventory.Badge;
import inventory.Gift;
import utils.Parser;

import java.util.Map;

public class OutputView {
    private static final String WELCOME_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String EVENT_PREVIEW_MESSAGE_FORMAT = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDER_MENU_MESSAGE = "<주문 메뉴>";
    private static final String ORDER_MENU_FORMAT = "%s %d개";
    private static final String GIFT_ITEM_MESSAGE = "<증정 메뉴>";
    private static final String BENEFITS_MESSAGE = "<혜택 내역>";
    private static final String BENEFIT_FORMAT = "%s: -%s";
    private static final String NOTHING = "없음";
    private static final int BENEFIT_ZERO = 0;
    private static final String EVENT_BADGE_MESSAGE = "<12월 이벤트 배지>";

    public static void printServiceStartMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    public static void printDate(int date) {
        System.out.println(date);
    }

    public static void printOrder(Map<String, Integer> orderMap) {
        String order = Parser.buildOrderString(orderMap);
        System.out.println(order);
    }

    public static void printEventPreviewMessage(int date) {
        System.out.println(String.format(EVENT_PREVIEW_MESSAGE_FORMAT, date));
    }

    public static void printOderMenuMessage() {
        System.out.println(ORDER_MENU_MESSAGE);
    }

    public static void printOderMenu(Map<String, Integer> order) {
        for (String menu : order.keySet()) {
            System.out.println(String.format(ORDER_MENU_FORMAT, menu, order.get(menu)));
        }
    }

    public static void printTotalPriceMessage(int totalPrice) {
        System.out.println(Amount.TOTAL_ORDER.getDescription());
        String money = Parser.formatNumberWithThousandsSeparator(totalPrice);
        System.out.println(money);
    }

    public static void printGiftItemMessage(int totalPrice) {
        System.out.println(GIFT_ITEM_MESSAGE);
        if (totalPrice >= Gift.CHAMPAGNE.getMinimumOrderAmount()) {
            System.out.println(Gift.CHAMPAGNE.getGiftDetail());
            return;
        }
        System.out.println(NOTHING);
    }

    public static void printBenefitsMessage(Map<String, Integer> benefifByDate) {
        System.out.println(BENEFITS_MESSAGE);
        for (String benefitType : benefifByDate.keySet()) {
            printBenefit(benefitType, benefifByDate.get(benefitType));
        }
        if (benefifByDate.isEmpty()) {
            System.out.println(NOTHING);
        }
    }

    private static void printBenefit(String benefitType, int benefit) {
        if (benefit != BENEFIT_ZERO) {
            String formattedBenefit = String.format(
                    BENEFIT_FORMAT, benefitType, Parser.formatNumberWithThousandsSeparator(benefit));
            System.out.println(formattedBenefit);
        }
    }

    public static void printTotalBenefitAmountMessage(int benefit) {
        System.out.println(Amount.TOTAL_BENEFIT.getDescription());
        System.out.println(Parser.formatNumberWithThousandsSeparator(-benefit));
    }

    public static void printDiscountedPayment(int totalPrice, int discount) {
        System.out.println(Amount.DISCOUNTED_PAYMENT.getDescription());
        System.out.println(Parser.formatNumberWithThousandsSeparator(totalPrice - discount));
    }

    public static void printEventBadgeMessage(int benefit) {
        System.out.println(EVENT_BADGE_MESSAGE);
        Badge badge = Badge.getBadgeForBenefit(benefit);
        System.out.println(badge.getName());
    }

}

