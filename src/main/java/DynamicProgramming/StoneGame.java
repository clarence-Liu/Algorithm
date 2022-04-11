package DynamicProgramming;

import java.util.Scanner;

/**
 * Alex and Lee play a game with piles of stones. There are an even number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].
 *
 * The objective of the game is to end with the most stones. The total number of stones is odd, so there are no ties.
 *
 * Alex and Lee take turns, with Alex starting first. Each turn, a player takes the entire pile of stones from either the beginning or the end of the row. This continues until there are no more piles left, at which point the person with the most stones wins.
 *
 * Assuming Alex and Lee play optimally, return True if and only if Alex wins the game.
 */
public class StoneGame {
    public static void main(String[] args){
        System.out.println("Give the piles of stones");
//        ArrayList<Integer> piles = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String pileString = scanner.nextLine();
        String[] pileStrings = pileString.split(" ");
        int[] piles = new int[pileStrings.length];
        int i = 0;
        for (String s :pileStrings) {
            piles[i++] = Integer.parseInt(s);
        }
        System.out.println(stoneGame(piles));
//        System.out.println(stoneGame(piles.stream().mapToInt(Integer::valueOf).toArray()));
    }

    public static boolean stoneGame(int[] piles) {

        return true;
    }
}
