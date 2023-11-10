package event;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum EventDate {
    CHRISTMAS(getDatesInRange(1, 25)),
    WEEKDAY(getWeekdayDatesInRange(3, 31)),
    WEEKEND(getWeekendDatesInRange(1, 30)),
    SPECIAL(Arrays.asList(3, 10, 17, 24, 25, 31)),
    GIFT(getDatesInRange(1, 31));

    private final List<Integer> dates;

    EventDate(List<Integer> dates) {
        this.dates = dates;
    }

    public List<Integer> getDates() {
        return dates;
    }
    private static List<Integer> getDatesInRange(int start, int end) {
        List<Integer> result = new ArrayList<>();
        for (int day = start; day <= end; day++) {
            result.add(day);
        }
        return result;
    }

    private static List<Integer> getWeekdayDatesInRange(int start, int end) {
        List<Integer> result = new ArrayList<>();
        for (int day = start; day <= end; day++) {
            LocalDate date = LocalDate.of(2023, 12, day);
            if (date.getDayOfWeek() != DayOfWeek.FRIDAY && date.getDayOfWeek() != DayOfWeek.SATURDAY) {
                result.add(day);
            }
        }
        return result;
    }

    private static List<Integer> getWeekendDatesInRange(int start, int end) {
        List<Integer> result = new ArrayList<>();
        for (int day = start; day <= end; day++) {
            LocalDate date = LocalDate.of(2023, 12, day);
            if (date.getDayOfWeek() == DayOfWeek.FRIDAY || date.getDayOfWeek() == DayOfWeek.SATURDAY) {
                result.add(day);
            }
        }
        return result;
    }
}
