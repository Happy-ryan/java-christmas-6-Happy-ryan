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

    public static void printTotalOrderPriceMessage(int totalOrderPrice) {
        System.out.println("<할인 전 총주문 금액>");
        String money = Parser.formatNumberWithThousandsSeparator(totalOrderPrice);
        System.out.println(money);
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

    public static void printBenefit(int day, Map<String, Integer> order){
        if(Event.CHRISTMAS.getDates().contains(day)){
            System.out.println();
        }
        if(Event.WEEKDAY.getDates().contains(day)){
            System.out.println();
        }
        if(Event.WEEKEND.getDates().contains(day)){
            System.out.println();
        }
        if(Event.SPECIAL.getDates().contains(day)){
            System.out.println();
        }
    }

    public static void printTotalBenefitAmountMessage() {
        System.out.println("<총혜택 금액>");
    }

    public static void printExpectedPaymentAmountMessage() {
        System.out.println("<할인 후 예상 결제 금액>");
    }

    public static void printEventBadgeMessage() {
        System.out.println("<12월 이벤트 배지>");
    }
}

