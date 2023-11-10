package view;

import amount.Amount;
import event.Event;
import menu.Menu;
import utils.Parser;

import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {
    public static void printServiceStartMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void printDate(int date) {
        System.out.println(date);
    }

    public static void printOrder(Map<String, Integer> order) {
        StringBuilder sb = new StringBuilder();
        for (String menu : order.keySet()) {
            sb.append(menu).append("-").append(order.get(menu)).append(",");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        System.out.println(sb.toString());
    }


    public static void printEventPreviewMessage(int date) {
        System.out.println("12월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
    }

    public static void printOderMenuMessage() {
        System.out.println("<주문 메뉴>");
    }

    public static void printOderMenu(Map<String, Integer> order) {
        for (String menu : order.keySet()) {
            System.out.println(menu + " " + order.get(menu) + "개");
        }
        System.out.println();
    }

    public static void printTotalOrderPriceMessage() {
        System.out.println(Amount.TOTAL_ORDER.getDescription());
        String money = Parser.formatNumberWithThousandsSeparator(Amount.TOTAL_ORDER.getValue());
        System.out.println(money + "\n");
    }

    public static void printBonusItemMessage() {
        System.out.println("<증정 메뉴>");
        if (Amount.TOTAL_ORDER.getValue() >= 120000) {
            System.out.println("샴페인 1개\n");
            return;
        }
        System.out.println("없음\n");
    }

    public static void printBenefitsMessage(Map<String, Integer> benefifByDate) {
        System.out.println("<혜택 내역>");
        for (String benefitType : benefifByDate.keySet()) {
            printBenefit(benefitType, benefifByDate.get(benefitType));
        }
        if (Amount.TOTAL_BENEFIT.getValue() == 0) {
            System.out.println("없음");
        }
        System.out.println();
    }

    private static void printBenefit(String benefitType, int benefit) {
        if (benefit != 0) {
            System.out.println(benefitType + " " + "-" + Parser.formatNumberWithThousandsSeparator(benefit));
        }
    }

    public static void printTotalBenefitAmountMessage() {
        System.out.println(Amount.TOTAL_BENEFIT.getDescription());
        if (Amount.TOTAL_BENEFIT.getValue() == 0) {
            System.out.println("0원\n");
            return;
        }
        System.out.println("-" + Parser.formatNumberWithThousandsSeparator(Amount.TOTAL_BENEFIT.getValue()));
        System.out.println();
    }

    public static void printDiscountedPayment() {
        System.out.println(Amount.DISCOUNTED_PAYMENT.getDescription());
        System.out.println(Parser.formatNumberWithThousandsSeparator(Amount.DISCOUNTED_PAYMENT.getValue()));
        System.out.println();
    }

    public static void printEventBadgeMessage() {
        System.out.println("<12월 이벤트 배지>");
        if (5000 <= Amount.TOTAL_BENEFIT.getValue() && Amount.TOTAL_BENEFIT.getValue() < 10000) {
            System.out.println("별");
            return;
        }
        if (10000 <= Amount.TOTAL_BENEFIT.getValue() && Amount.TOTAL_BENEFIT.getValue() < 20000) {
            System.out.println("트리");
            return;
        }
        if (20000 <= Amount.TOTAL_BENEFIT.getValue()) {
            System.out.println("산타");
            return;
        }
        System.out.println("없음");
    }
}

