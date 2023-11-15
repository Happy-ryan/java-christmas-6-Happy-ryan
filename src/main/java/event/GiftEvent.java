package event;

import inventory.Gift;
import menu.Receipt;

public class GiftEvent extends Event {
    public GiftEvent() {
        super(EventDescription.GIFT);
    }

    @Override
    public boolean tryUse(int day, Receipt receipt) {
        return super.tryUse(day, receipt) && receipt.getTotalPrice() >= Gift.CHAMPAGNE.getMinimumOrderAmount();
    }

    public int getBenefit(int day, Receipt receipt) {
        return getDescription().getBenefit();
    }

    public int getDiscount(int day, Receipt receipt) {
        return getDescription().getDiscount();
    }
}
