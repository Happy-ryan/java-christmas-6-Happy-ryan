package christmas;

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

        OutputView.printEventPreviewMessage(date);
        System.out.println();

        OutputView.printOderMenuMessage();
        OutputView.printOderMenu(order);
        System.out.println();

        Calculrator calculrator = new Calculrator(date, order);
        calculrator.calculateTotalOrderPrice();
        Map<String, Integer> benefitByDate = calculrator.calculateBenefitByDate();

        OutputView.printTotalOrderPriceMessage();
        System.out.println();

        OutputView.printBonusItemMessage();
        System.out.println();

        OutputView.printBenefitsMessage(benefitByDate);
        System.out.println();

        OutputView.printTotalBenefitAmountMessage();
        System.out.println();

        calculrator.calculateDiscountedPayment();

        OutputView.printDiscountedPayment();
        System.out.println();

        OutputView.printEventBadgeMessage();
    }
}
