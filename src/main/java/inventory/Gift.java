package inventory;

public enum Gift {
    CHAMPAGNE("샴페인", 120000, "샴페인 1개");

    private final String name;
    private final int minimumOrderAmount;
    private final String giftDetail;

    Gift(String name, int minimumOrderAmount, String giftDetail) {
        this.name = name;
        this.minimumOrderAmount = minimumOrderAmount;
        this.giftDetail = giftDetail;
    }

    public String getName() {
        return name;
    }

    public int getMinimumOrderAmount() {
        return minimumOrderAmount;
    }

    public String getGiftDetail() {
        return giftDetail;
    }
}

