package christmas;

import menu.Receipt;
import utils.Calculator;
import view.InputView;
import view.OutputView;

import java.util.Map;

public class ChristmasPromotion {

    public void start() {
        printServiceStartMessage();

        int date = readDate();
        printDate(date);

        Map<String, Integer> order = readOrder();
        printOrderDetails(order);

        Receipt receipt = new Receipt(order);

        printEventPreviewMessage(date);
        System.out.println();

        printOrderMenuDetails(order);
        System.out.println();

        Calculator calculator = new Calculator(date, receipt);

        printReceiptDetails(receipt);
        printCalculatorDetails(receipt, calculator);
    }

    private void printServiceStartMessage() {
        OutputView.printServiceStartMessage();
    }

    private int readDate() {
        return InputView.readDate();
    }

    private void printDate(int date) {
        OutputView.printDate(date);
    }

    private Map<String, Integer> readOrder() {
        return InputView.readOrder();
    }

    private void printOrderDetails(Map<String, Integer> order) {
        OutputView.printOrder(order);
    }

    private void printEventPreviewMessage(int date) {
        OutputView.printEventPreviewMessage(date);
    }

    private void printOrderMenuDetails(Map<String, Integer> order) {
        OutputView.printOderMenuMessage();
        OutputView.printOderMenu(order);
    }

    private void printReceiptDetails(Receipt receipt) {
        OutputView.printTotalPriceMessage(receipt.getTotalPrice());
        System.out.println();

        OutputView.printGiftItemMessage(receipt.getTotalPrice());
        System.out.println();
    }

    private void printCalculatorDetails(Receipt receipt, Calculator calculator) {
        OutputView.printBenefitsMessage(calculator.getBenefit());
        System.out.println();

        OutputView.printTotalBenefitAmountMessage(calculator.getTotalBenefit());
        System.out.println();

        OutputView.printDiscountedPayment(receipt.getTotalPrice(), calculator.getTotalDiscount());
        System.out.println();

        OutputView.printEventBadgeMessage(calculator.getTotalBenefit());
    }
}
