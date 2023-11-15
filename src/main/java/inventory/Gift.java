package inventory;

public enum Gift {
    CHAMPAGNE("샴페인", 120000);

    private final String name;
    private final int minimumOrderAmount;

    Gift(String name, int minimumOrderAmount) {
        this.name = name;
        this.minimumOrderAmount = minimumOrderAmount;
    }

    public String getName() {
        return name;
    }

    public int getMinimumOrderAmount() {
        return minimumOrderAmount;
    }
}

