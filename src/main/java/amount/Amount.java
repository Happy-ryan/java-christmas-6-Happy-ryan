package amount;

public enum Amount {
    TOTAL_ORDER("<할인 전 총주문 금액>", 0),
    TOTAL_BENEFIT("<총혜택 금액>", 0),
    DISCOUNTED_PAYMENT("<할인 후 예상 결제 금액>", 0);

    private final String description;
    private int value;

    Amount(String description, int initialValue) {
        this.description = description;
        this.value = initialValue;
    }

    public String getDescription() {
        return this.description;
    }

    public int getValue() {
        return this.value;
    }

    public void increaseAmount(int amount) {
        this.value += amount;
    }

    public void add(Amount other) {
        this.value += other.getValue();
    }

    public void minus(Amount other) {
        this.value -= other.getValue();
    }
}