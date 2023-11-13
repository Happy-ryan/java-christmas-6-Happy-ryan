package event;

import menu.Receipt;

import java.util.ArrayList;
import java.util.List;

public class EventHandler {
    private static List<Event> eventList;

    static {
        eventList = new ArrayList<>();
        eventList.add(new ChristmasEvent());
        eventList.add(new WeekdayEvent());
        eventList.add(new WeekendEvent());
        eventList.add(new SpecialEvent());
        eventList.add(new GiftEvent());
    }

    public static List<Event> getUsableEvent(int day, Receipt receipt) {
        List<Event> usableEvent = new ArrayList<>();
        for (Event event : eventList) {
            if (event.tryUse(day, receipt)) {
                usableEvent.add(event);
            }
        }
        return usableEvent;
    }
}
