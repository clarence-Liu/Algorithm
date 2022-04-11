package Z_Entry;

import HashTable.DistributeCandies;

public class CallFunction12 {
    public static void main(String[] args) {
        // 575. Distribute Candies
        System.out.println("575. Distribute Candies");
        DistributeCandies candies = new DistributeCandies();
        int[] candyType = {1,1,2,2,3,3};
        System.out.println("Output : " + candies.distributeCandies(candyType));
        System.out.println();
    }
}
