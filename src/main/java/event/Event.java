package event;

import menu.Receipt;

public abstract class Event {
    private final EventDescription description;

    Event(EventDescription eventDescription) {
        this.description = eventDescription;
    }

    public EventDescription getDescription() {
        return description;
    }

    public boolean tryUse(int day, Receipt receipt) {
        return description.getDates().contains(day) && receipt.getTotalPrice() >= 10000;
    }

    public abstract int getBenefit(int day, Receipt receipt);

    public abstract int getDiscount(int day, Receipt receipt);
}