import java.util.ArrayList;

public class HandRanker {

    /**
     * Class HandRanker have two not private static methods.
     * Method rankCounter create new int array with 14 elements,
     * they contain count of entering all type off cards in player hand.
     * Example if player have 3 Jacks, the 11 position of array be 3.
     * @param cards player hand cards array
     * @return int array
     */
    static int[] rankCounter(ArrayList<Card> cards) {
        ArrayList<Integer> ranks = new ArrayList<>();
        for (Card card : cards)
            ranks.add(card.getRank().getValue());

        int[] counts = new int[14];
        for (Integer rank : ranks)
            counts[rank - 1]++;
        return counts;
    }

    /**
     * Method playerHandRanker take in parameter array of player hand cards,
     * and start check its rank from high priority rank to lower.
     * First use royalFlushChecker and finish with onePairChecker, if some check
     * point equals true, its return player hand rank, else method return HIGH_CARD.
     * @param cards player hand cards array
     * @return rank of player hand
     */
    static HandRank playerHandRanker(ArrayList<Card> cards) {
        if (royalFlushChecker(cards))
            return HandRank.ROYAL_FLUSH;
        if (straightFlushChecker(cards))
            return HandRank.STRAIGHT_FLUSH;
        if (fourOfKindChecker(cards))
            return HandRank.FOUR_OF_KIND;
        if (fullHouseChecker(cards))
            return HandRank.FULL_HOUSE;
        if (flushChecker(cards))
            return HandRank.FLUSH;
        if (straightFlushChecker(cards))
            return HandRank.STRAIGHT;
        if (treeOfKindChecker(cards))
            return HandRank.THREE_OF_KIND;
        if (twoPairsChecker(cards))
            return HandRank.TWO_PAIRS;
        if (onePairChecker(cards))
            return HandRank.ONE_PAIR;

        return HandRank.HIGH_CARD;
    }

    private static boolean royalFlushChecker(ArrayList<Card> cards) {
        return straightFlushChecker(cards) && cards.get(0).getRank().getValue() == 10;
    }

    private static boolean straightFlushChecker(ArrayList<Card> cards) {
        return flushChecker(cards) && straightChecker(cards);
    }

    private static boolean fourOfKindChecker(ArrayList<Card> cards) {
        int[] counts = rankCounter(cards);
        for (int count : counts) {
            if (count == 4) {
                return true;
            }
        }
        return false;
    }

    private static boolean fullHouseChecker(ArrayList<Card> cards) {
        return treeOfKindChecker(cards) && onePairChecker(cards);
    }

    private static boolean flushChecker(ArrayList<Card> cards) {
        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i).getSuit().getValue() != cards.get(i + 1).getSuit().getValue())
                return false;
        }
        return true;
    }

    private static boolean straightChecker(ArrayList<Card> cards) {
        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i + 1).getRank().getValue() - cards.get(i).getRank().getValue() != 1)
                return false;
        }
        return true;
    }

    private static boolean treeOfKindChecker(ArrayList<Card> cards) {
        int[] counts = rankCounter(cards);
        for (int count : counts) {
            if (count == 3) {
                return true;
            }
        }
        return false;
    }

    private static boolean twoPairsChecker(ArrayList<Card> cards) {
        return (pairCounter(cards) == 2);
    }

    private static boolean onePairChecker(ArrayList<Card> cards) {
        return (pairCounter(cards) == 1);
    }

    private static int pairCounter(ArrayList<Card> cards) {
        int[] counts = rankCounter(cards);
        int pairCounter = 0;
        for (int count : counts) {
            if (count == 2) {
                pairCounter++;
            }
        }
        return pairCounter;
    }
}
