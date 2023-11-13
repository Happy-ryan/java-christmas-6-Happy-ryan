package event;

import java.util.List;

public enum EventDescription {
    CHRISTMAS("크리스마스 디데이 할인: ", 1000, EventDate.CHRISTMAS.getDates()),
    WEEKDAY("평일 할인: ", 2023, EventDate.WEEKDAY.getDates()),
    WEEKEND("주말 할인: ", 2023, EventDate.WEEKEND.getDates()),
    SPECIAL("특별 할인: ", 1000, EventDate.SPECIAL.getDates()),
    GIFT("증정 이벤트:", 25000, EventDate.GIFT.getDates());

    private final String type;
    private final int discount;
    private final List<Integer> dates;

    EventDescription(String type, int discount, List<Integer> dates) {
        this.type = type;
        this.discount = discount;
        this.dates = dates;
    }

    public String getType() {
        return type;
    }

    public int getDiscount() {
        return discount;
    }

    public List<Integer> getDates() {
        return dates;
    }
}
