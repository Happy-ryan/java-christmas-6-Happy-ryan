package event;

import menu.Receipt;

public class GiftEvent extends Event {
    public GiftEvent() {
        super(EventDescription.GIFT);
    }

    @Override
    public boolean tryUse(int day, Receipt receipt) {
        return super.tryUse(day, receipt) && receipt.getTotalPrice() >= 120000;
    }

    public int getBenefit(int day, Receipt receipt) {
        return getDescription().getBenefit();
    }

    public int getDiscount(int day, Receipt receipt) {
        return getDescription().getDiscount();
    }
}
