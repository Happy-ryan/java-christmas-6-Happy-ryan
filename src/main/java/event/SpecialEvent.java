package event;

import menu.Receipt;

public class SpecialEvent extends Event {
    public SpecialEvent() {
        super(EventDescription.SPECIAL);
    }

    @Override
    public boolean tryUse(int day, Receipt receipt) {
        return super.tryUse(day, receipt);
    }

    public int getBenefit(int day, Receipt receipt) {
        return getDescription().getBenefit();
    }

    public int getDiscount(int day, Receipt receipt) {
        return getDescription().getDiscount();
    }
}
