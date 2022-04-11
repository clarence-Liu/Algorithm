package Z_Entry;

import HashTable.BullsAndCows;
import Other.GameOfLife;

public class CallFunction6 {
    public static void main(String[] args) {
        // 289. Game of Life
        System.out.println("289. Game of Life");
        GameOfLife life = new GameOfLife();
        life.gameOfLife(new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}});
        System.out.println();

        // 299. Bulls And Cows
        System.out.println("299. Bulls And Cows");
        BullsAndCows bullsAndCows = new BullsAndCows();
        System.out.println("Output : " + bullsAndCows.getHint("1807","7810"));
        System.out.println("Output : " + bullsAndCows.getHint("1123","0111"));
        System.out.println("Output : " + bullsAndCows.getHint("1122","1222"));
        System.out.println();
    }
}
