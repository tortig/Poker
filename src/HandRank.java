public enum HandRank {
    HIGH_CARD("HighCard", 1),           //Highest value card.
    ONE_PAIR("OnePair", 2),             //Two cards of the same value.
    TWO_PAIRS("TwoPairs", 3),           //Two different pairs.
    THREE_OF_KIND("ThreeOfKind", 4),    //Three cards of the same value.
    STRAIGHT("Straight", 5),            //All cards are consecutive values.
    FLUSH("Flush", 6),                  //All cards of the same suit.
    FULL_HOUSE("FullHouse", 7),         //Three of a kind and a pair.
    FOUR_OF_KIND("FourOfKind", 8),      //Four cards of the same value.
    STRAIGHT_FLUSH("StraightFlush", 9), // All cards are consecutive values of same suit
    ROYAL_FLUSH("RoyalFlush", 10),;     // Ten, Jack, Queen, King, Ace, in same suit.

    private String name;
    private int value;

    HandRank(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
