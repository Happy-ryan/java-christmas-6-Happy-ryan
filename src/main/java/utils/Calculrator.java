package utils;

import amount.Amount;
import event.Event;
import event.EventDescription;
import event.EventHandler;
import menu.Menu;
import menu.MenuCategory;
import menu.Receipt;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Calculrator {
    private final int day;
    private final Receipt receipt;
    private final List<Event> usableEvents;

    public Calculrator(int day, Receipt receipt) {
        this.day = day;
        this.receipt = receipt;
        this.usableEvents = EventHandler.getUsableEvent(day, receipt);
    }

    public Map<String, Integer> getBenefit() {
        Map<String, Integer> result = new HashMap<>();
        for (Event event : usableEvents) {
            result.put(event.getDescription().getType(), event.getBenefit(day, receipt));
        }
        return result;
    }

    public int getTotalBenefit() {
        int result = 0;
        for (Map.Entry<String, Integer> m : getBenefit().entrySet()) {
            result += m.getValue();
        }
        return result;
    }

    public Map<String, Integer> getDiscount() {
        Map<String, Integer> result = new HashMap<>();
        for (Event event : usableEvents) {
            result.put(event.getDescription().getType(), event.getDiscount(day, receipt));
        }
        return result;
    }

    public int getTotalDiscount() {
        int result = 0;
        for (Map.Entry<String, Integer> m : getDiscount().entrySet()) {
            result += m.getValue();
        }
        return result;
    }

}
