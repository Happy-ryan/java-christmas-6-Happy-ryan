package amount;

public enum Amount {
    TOTAL_ORDER("<할인 전 총주문 금액>"),
    TOTAL_BENEFIT("<총혜택 금액>"),
    DISCOUNTED_PAYMENT("<할인 후 예상 결제 금액>");

    private final String description;

    Amount(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}