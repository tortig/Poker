import java.util.ArrayList;

public class RankComparator {

    /**
     * Class RankComparator have only one static not private method compare().
     * Method take in parameters both players hand card arrays and compare them.
     * First method check if players have hands wits different rank, in this case
     * win player whose hand cards rank is higher, else if they have hands with
     * similar rank , method start check all possible cases in if conditions.
     * @param playerOne hand card array
     * @param playerTwo hand card array
     * @return "Player1" if player one win, "Player2" if player two win
     * and "Equals" if players have equal hands
     */
    static String compare(ArrayList<Card> playerOne, ArrayList<Card> playerTwo) {
        // players have different cards rank
        if (HandRanker.playerHandRanker(playerOne).getValue() > HandRanker.playerHandRanker(playerTwo).getValue())
            return "Player1";
        if (HandRanker.playerHandRanker(playerOne).getValue() < HandRanker.playerHandRanker(playerTwo).getValue())
            return "Player2";

        // Both player have High Card
        highCard(playerOne, playerTwo);

        // Both player have One Pair
        if (HandRanker.playerHandRanker(playerOne).getValue() == 2 &&
                HandRanker.playerHandRanker(playerTwo).getValue() == 2) {
            int[] one = HandRanker.rankCounter(playerOne);
            int[] two = HandRanker.rankCounter(playerTwo);
            for (int i = one.length - 1; i >= 0; i--) {
                if (one[i] == 2 && two[i] != 2)
                    return "Player1";

                if (two[i] == 2 && one[i] != 2)
                    return "Player2";

                if (two[i] == 2 && one[i] == 2)
                    highCard(playerOne, playerTwo);
            }
        }

        // Both player have Two Pairs
        if (HandRanker.playerHandRanker(playerOne).getValue() == 3 &&
                HandRanker.playerHandRanker(playerTwo).getValue() == 3) {
            int[] one = HandRanker.rankCounter(playerOne);
            int[] two = HandRanker.rankCounter(playerTwo);
            int pairCounter = 0;
            for (int i = one.length - 1; i >= 0; i--) {
                if (one[i] == 2 && two[i] != 2) {
                    return "Player1";
                }
                if (two[i] == 2 && one[i] != 2)
                    return "Player2";

                if (two[i] == 2 && one[i] == 2) {
                    if (pairCounter == 0) {
                        pairCounter++;
                        continue;
                    }
                    highCard(playerOne, playerTwo);
                }
            }
        }

        // Both player have Tree of Kind
        if (HandRanker.playerHandRanker(playerOne).getValue() == 4 &&
                HandRanker.playerHandRanker(playerTwo).getValue() == 4) {
            int[] one = HandRanker.rankCounter(playerOne);
            int[] two = HandRanker.rankCounter(playerTwo);
            for (int i = one.length - 1; i >= 0; i--) {
                if (one[i] == 3)
                    return "Player1";

                if (two[i] == 3)
                    return "Player2";
            }
        }

        // Both player have Straight
        if (HandRanker.playerHandRanker(playerOne).getValue() == 5 &&
                HandRanker.playerHandRanker(playerTwo).getValue() == 5)
            highCard(playerOne, playerTwo);

        // Both player have Flush
        if (HandRanker.playerHandRanker(playerOne).getValue() == 6 &&
                HandRanker.playerHandRanker(playerTwo).getValue() == 6)
            highCard(playerOne, playerTwo);

        // Both player have Full House
        if (HandRanker.playerHandRanker(playerOne).getValue() == 7 &&
                HandRanker.playerHandRanker(playerTwo).getValue() == 7) {
            int[] one = HandRanker.rankCounter(playerOne);
            int[] two = HandRanker.rankCounter(playerTwo);
            for (int i = one.length - 1; i >= 0; i--) {
                if (one[i] == 3)
                    return "Player1";

                if (two[i] == 3)
                    return "Player2";
            }
        }

        // Both player have Four of Kind
        if (HandRanker.playerHandRanker(playerOne).getValue() == 8 &&
                HandRanker.playerHandRanker(playerTwo).getValue() == 8) {
            int[] one = HandRanker.rankCounter(playerOne);
            int[] two = HandRanker.rankCounter(playerTwo);
            for (int i = one.length - 1; i >= 0; i--) {
                if (one[i] == 4)
                    return "Player1";

                if (two[i] == 4)
                    return "Player2";
            }
        }

        // Both player have Straight Flush
        if (HandRanker.playerHandRanker(playerOne).getValue() == 9 &&
                HandRanker.playerHandRanker(playerTwo).getValue() == 9)
            highCard(playerOne, playerTwo);

        // Both player have Royal Flush
        if (HandRanker.playerHandRanker(playerOne).getValue() == 10 &&
                HandRanker.playerHandRanker(playerTwo).getValue() == 10)
            highCard(playerOne, playerTwo);

        return highCard(playerOne, playerTwo);
    }

    //find winner when both players have HIGH_CARD combination
    private static String highCard(ArrayList<Card> playerOne, ArrayList<Card> playerTwo) {
        if (HandRanker.playerHandRanker(playerOne).getValue() == 1 &&
                HandRanker.playerHandRanker(playerTwo).getValue() == 1) {
            for (int i = playerOne.size() - 1; i >= 0; i--) {
                if (playerOne.get(i).getRank().getValue() > playerTwo.get(i).getRank().getValue())
                    return "Player1";

                if (playerOne.get(i).getRank().getValue() < playerTwo.get(i).getRank().getValue())
                    return "Player2";
            }
        }
        return "Equal  ";
    }
}
