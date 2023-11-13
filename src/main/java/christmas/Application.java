package christmas;

import menu.Receipt;
import utils.Calculrator;
import view.InputView;
import view.OutputView;

import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.printServiceStartMessage();

        int date = InputView.readDate();
        OutputView.printDate(date);

        Map<String, Integer> order = InputView.readOrder();
        OutputView.printOrder(order);
        Receipt receipt = new Receipt(order);

        OutputView.printEventPreviewMessage(date);
        System.out.println();

        OutputView.printOderMenuMessage();
        OutputView.printOderMenu(order);
        System.out.println();

        Calculrator calculator = new Calculrator(date, receipt);

        OutputView.printTotalPriceMessage(receipt.getTotalPrice());
        System.out.println();

        OutputView.printBonusItemMessage(receipt.getTotalPrice());
        System.out.println();

        OutputView.printBenefitsMessage(calculator.getBenefit());
        System.out.println();

        OutputView.printTotalBenefitAmountMessage(calculator.getTotalBenefit());
        System.out.println();

        OutputView.printDiscountedPayment(receipt.getTotalPrice(), calculator.getTotalDiscount());
        System.out.println();

        OutputView.printEventBadgeMessage(calculator.getTotalBenefit());
    }
}
