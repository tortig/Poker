import java.util.Comparator;
import java.util.Objects;

public class Card {
    private CardRank rank;
    private CardSuit suit;

    Card(CardRank rank, CardSuit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    CardRank getRank() {
        return rank;
    }

    public CardSuit getSuit() {
        return suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return rank == card.rank &&
                suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }

    @Override
    public String toString() {
        return "" + rank.getValue() + ", ";
    }

    //-------------------Nested Class Card Comparator-----------------------
    static class CardComparator implements Comparator<Card> {
        @Override
        public int compare(Card card1, Card card2) {
            if (card1.getRank().getValue() > card2.getRank().getValue())
                return 1;
            else if (card1.getRank().getValue() < card2.getRank().getValue())
                return -1;
            return 0;
        }
    }
}
