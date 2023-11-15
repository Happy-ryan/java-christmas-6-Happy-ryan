package inventory;

public enum Badge {
    UNKNOWN("없음", Integer.MIN_VALUE, Integer.MIN_VALUE),
    STAR("별", 5000, 10000),
    TREE("트리", 10000, 20000),
    SANTA("산타", 20000, Integer.MAX_VALUE);

    private final String name;
    private final int minBenefit;
    private final int maxBenefit;

    Badge(String name, int minBenefit, int maxBenefit) {
        this.name = name;
        this.minBenefit = minBenefit;
        this.maxBenefit = maxBenefit;
    }

    public String getName() {
        return name;
    }

    public boolean isInRange(int benefit) {
        return benefit >= minBenefit && benefit < maxBenefit;
    }

    public static Badge getBadgeForBenefit(int benefit) {
        for (Badge badge : values()) {
            if (badge.isInRange(benefit)) {
                return badge;
            }
        }
        return UNKNOWN;
    }
}

