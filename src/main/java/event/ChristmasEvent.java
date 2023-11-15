package event;

import menu.Receipt;

public class ChristmasEvent extends Event {
    public ChristmasEvent() {
        super(EventDescription.CHRISTMAS);
    }

    @Override
    public boolean tryUse(int day, Receipt receipt) {
        return super.tryUse(day, receipt);
    }

    public int getBenefit(int day, Receipt receipt) {
        return getDescription().getBenefit() + 100 * (day - 1);
    }

    public int getDiscount(int day, Receipt receipt) {
        return getDescription().getDiscount() + 100 * (day - 1);
    }
}
