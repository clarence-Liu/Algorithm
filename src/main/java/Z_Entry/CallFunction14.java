package Z_Entry;

import Graph.RedundantConnection;

/**
 * 650-700
 */
public class CallFunction14 {
    public static void main(String[] args) {
        // 684. Redundant Connection
        System.out.println("684. Redundant Connection");
        RedundantConnection connection = new RedundantConnection();
        System.out.println("Output : " + Print.print(connection.findRedundantConnection(new int[][]{{9,10},{5,8},{2,6},{1,5},{3,8},{4,9},{8,10},{4,10},{6,8},{7,9}})));
    }
}
