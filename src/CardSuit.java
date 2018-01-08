public enum CardSuit {
    CLUBS("C", 1),
    DIAMONDS("D", 2),
    HEARTS("H", 3),
    SPADES("S", 4),;

    private String name;
    private int value;

    CardSuit(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static CardSuit getByName(final String name) {
        for (CardSuit suit : values()) {
            if (suit.name.equals(name)) {
                return suit;
            }
        }
        throw new IllegalArgumentException("Card Suit with name " + name + " not found");
    }
}
