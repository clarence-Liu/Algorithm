package Z_Entry;

import BackTracking.ZumaGame;
import Greedy.AssignCookies;
import Other.TeemoAttacking;

public class CallFunction10 {
    public static void main(String[] args) {
        // 455. Assign Cookies
        System.out.println("455. Assign Cookies");
        AssignCookies assignCookies = new AssignCookies();
        System.out.println("Output : " + assignCookies.findContentChildren(new int[]{1,2}, new int[]{1,2,3}));
        System.out.println();

        // 488. Zuma Game
        System.out.println("488. Zuma Game");
        ZumaGame game = new ZumaGame();
        System.out.println("Output : " + game.findMinStep("WWRRBBWW", "WRBRW"));
        System.out.println();

        // 495. Teemo Attacking
        System.out.println("495. Teemo Attacking");
        TeemoAttacking attacking = new TeemoAttacking();
        System.out.println("Output : " + attacking.findPoisonedDuration(new int[]{1,2}, 2));
        System.out.println();
    }
}
