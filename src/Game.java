import java.io.*;
import java.util.ArrayList;

public class Game {

    /**
     * the method read string from file while its not null,
     * parse that string and take Array of Cards, after
     * divide array of cards between two players
     * use card comparator and sort cards of players,
     * After write the string in file and use RankComparator.compare(playerOne, playerTwo)
     * static method to identify the winner and concat the winner name to that string.
     * @param readFile  read from this file
     * @param writeFile write in this file
     */
    static void stringReaderWriter(String readFile, String writeFile) { // name of file
        String line;
        // try to read line from file while not null
        try (BufferedReader reader = new BufferedReader(new FileReader(readFile))) {
            while ((line = reader.readLine()) != null) {
                ArrayList<Card> cards = stringParser(line); // use parser and have array of Cards
                ArrayList<Card> playerOne = new ArrayList<>();  // player one hand
                ArrayList<Card> playerTwo = new ArrayList<>();  // player two hand

                for (int i = 0; i < cards.size(); i++) {    // divide array to two parts
                    if (i < 5)
                        playerOne.add(cards.get(i));
                    else
                        playerTwo.add(cards.get(i));
                }

                // use card comparator and sort cards of players, from small rank to high
                Card.CardComparator cardComp = new Card.CardComparator();
                playerOne.sort(cardComp);   // player one sorted hand
                playerTwo.sort(cardComp);   // player two sorted hand

                // write in result file, method compare return name of player who win
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(writeFile, true))) {
                    writer.write(line + " - " + RankComparator.compare(playerOne, playerTwo) + " (" +
                            HandRanker.playerHandRanker(playerOne)+", "+HandRanker.playerHandRanker(playerTwo)+")\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //----------------------------Pars String to Cards Array---------------------------------
    private static ArrayList<Card> stringParser(String str) {
        ArrayList<Card> cards = new ArrayList<>();
        CardRank rank;
        CardSuit suit;

        for (int k = 0; k < 10; k++) {
            rank = CardRank.getByName(str.charAt(k * 3) + "");
            suit = CardSuit.getByName(str.charAt(k * 3 + 1) + "");
            cards.add(new Card(rank, suit));
        }
        return cards;
    }

}
