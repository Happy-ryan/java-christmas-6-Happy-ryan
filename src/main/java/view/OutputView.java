package view;

import amount.Amount;
import utils.Parser;

import java.util.Map;

public class OutputView {
    public static void printServiceStartMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void printDate(int date) {
        System.out.println(date);
    }

    public static void printOrder(Map<String, Integer> orderMap) {
        String order = Parser.buildOrderString(orderMap);
        System.out.println(order);
    }

    public static void printEventPreviewMessage(int date) {
        System.out.println("12월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    public static void printOderMenuMessage() {
        System.out.println("<주문 메뉴>");
    }

    public static void printOderMenu(Map<String, Integer> order) {
        for (String menu : order.keySet()) {
            System.out.println(menu + " " + order.get(menu) + "개");
        }
    }

    public static void printTotalPriceMessage(int totalPrice) {
        System.out.println(Amount.TOTAL_ORDER.getDescription());
        String money = Parser.formatNumberWithThousandsSeparator(totalPrice);
        System.out.println(money);
    }

    public static void printBonusItemMessage(int totalPrice) {
        System.out.println("<증정 메뉴>");
        if (totalPrice >= 120000) {
            System.out.println("샴페인 1개");
            return;
        }
        System.out.println("없음");
    }

    public static void printBenefitsMessage(Map<String, Integer> benefifByDate) {
        System.out.println("<혜택 내역>");
        for (String benefitType : benefifByDate.keySet()) {
            printBenefit(benefitType, benefifByDate.get(benefitType));
        }
        if (Amount.TOTAL_BENEFIT.getValue() == 0) {
            System.out.println("없음");
        }
    }

    private static void printBenefit(String benefitType, int benefit) {
        if (benefit != 0) {
            System.out.println(benefitType + " " + "-" + Parser.formatNumberWithThousandsSeparator(benefit));
        }
    }

    public static void printTotalBenefitAmountMessage(int benefit) {
        System.out.println(Amount.TOTAL_BENEFIT.getDescription());
        System.out.println(Parser.formatNumberWithThousandsSeparator(-benefit));
    }

    public static void printDiscountedPayment(int discount) {
        System.out.println(Amount.DISCOUNTED_PAYMENT.getDescription());
        System.out.println(Parser.formatNumberWithThousandsSeparator(discount));
    }

    public static void printEventBadgeMessage(int benefit) {
        System.out.println("<12월 이벤트 배지>");
        if (5000 <= benefit && benefit < 10000) {
            System.out.println("별");
            return;
        }
        if (10000 <= benefit && benefit < 20000) {
            System.out.println("트리");
            return;
        }
        if (20000 <= benefit) {
            System.out.println("산타");
            return;
        }
        System.out.println("없음");
    }
}

