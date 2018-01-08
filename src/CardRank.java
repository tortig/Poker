public enum CardRank {
    JOKER("1", 1),
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("T", 10),
    JACK("J", 11),
    QUEEN("Q", 12),
    KING("K", 13),
    ACE("A", 14),;

    private String name;
    private int value;

    CardRank(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static CardRank getByName(final String name) {
        for (CardRank rank : values()) {
            if (rank.name.equals(name)) {
                return rank;
            }
        }
        throw new IllegalArgumentException("Card Rank with name " + name + " not found");
    }
}
