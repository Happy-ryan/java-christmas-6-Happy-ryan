package event;

import menu.Receipt;

public class WeekdayEvent extends Event {
    public WeekdayEvent() {
        super(EventDescription.WEEKDAY);
    }

    @Override
    public boolean tryUse(int day, Receipt receipt) {
        return super.tryUse(day, receipt) &&
                receipt.getDessertCount() > 0;
    }

    public int getBenefit(int day, Receipt receipt) {
        return getDescription().getBenefit() * receipt.getDessertCount();
    }

    public int getDiscount(int day, Receipt receipt) {
        return getDescription().getDiscount() * receipt.getDessertCount();
    }
}
