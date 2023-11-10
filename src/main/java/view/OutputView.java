package view;

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
        System.out.println("<주문메뉴>");
    }

    public static void printOderMenu(Map<String, Integer> order) {
        for (String menu : order.keySet()) {
            System.out.println(menu + " " + order.get(menu) + "개");
        }
        System.out.println();
    }

    public static void printOrderDetailsUnder10000(int totalOrderPrice) {
        System.out.println("<할인 전 총주문 금액>");
        String money = Parser.formatNumberWithThousandsSeparator(totalOrderPrice);
        System.out.println(money + "원\n");
        System.out.println("<증정메뉴>\n없음\n");
        System.out.println("<혜택내역>\n없음\n");
        System.out.println("<총혜택 금액>\n없음\n");
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(money + "원\n");
        System.out.println("<12월 이벤츠 배지>\n없음");
    }

    public static void printTotalOrderPriceMessage(int totalOrderPrice) {
        System.out.println("<할인 전 총주문 금액>");
        String money = Parser.formatNumberWithThousandsSeparator(totalOrderPrice);
        System.out.println(money + "\n");
    }

    public static void printBonusItemMessage(int totalOrderPrice) {
        System.out.println("<증정 메뉴>");
        if (totalOrderPrice >= 120000) {
            System.out.println("샴페인 1개\n");
            return;
        }
        System.out.println("없음\n");
    }

    public static void printBenefitsMessage() {
        System.out.println("<혜택 내역>");
    }

    public static void printBenefit(Map<String, Integer> benefifByDate) {
        for (String benefitType : benefifByDate.keySet()) {
            printBenefit(benefitType, benefifByDate.get(benefitType));
        }
        System.out.println();
        printTotalBenefitAmountMessage(benefifByDate.get("totalBenefitAmount"));
    }

    private static void printBenefit(String benefitType, int benefit) {
        if (!benefitType.equals("totalAfterExcludingGiftDiscount") && !benefitType.equals("totalBenefitAmount")) {
            System.out.println(benefitType + " " + "-" + Parser.formatNumberWithThousandsSeparator(benefit));
        }
    }

    public static void printTotalBenefitAmountMessage(int totalBenefitAmount) {
        System.out.println("<총혜택 금액>");
        System.out.println("-" + Parser.formatNumberWithThousandsSeparator(totalBenefitAmount));
    }

    public static void printExpectedPaymentAmountMessage() {
        System.out.println("<할인 후 예상 결제 금액>");
    }

    public static void printEventBadgeMessage() {
        System.out.println("<12월 이벤트 배지>");
    }

}

