package event;

import menu.Receipt;

public class WeekendEvent extends Event {
    public WeekendEvent() {
        super(EventDescription.WEEKEND);
    }

    @Override
    public boolean tryUse(int day, Receipt receipt) {
        return super.tryUse(day, receipt) && receipt.getMainCount() > 0;
    }

    public int getBenefit(int day, Receipt receipt) {
        return getDescription().getBenefit() * receipt.getMainCount();
    }

    public int getDiscount(int day, Receipt receipt) {
        return getDescription().getDiscount() * receipt.getMainCount();
    }
}
