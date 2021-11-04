import java.util.*;

/**
 * A linked list of length n is given such that each node contains
 * an additional random pointer, which could point to any node in the list, or null.
 *
 * Construct a deep copy of the list.
 * The deep copy should consist of exactly n brand new nodes,
 * where each new node has its value set to the value of its corresponding original node.
 * Both the next and random pointer of the new nodes should point to new nodes
 * in the copied list such that the pointers in the original list and
 * copied list represent the same list state.
 * None of the pointers in the new list should point to nodes in the original list.
 *
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y,
 * then for the corresponding two nodes x and y in the copied list, x.random --> y.
 *
 * Return the head of the copied linked list.
 *
 * The linked list is represented in the input/output as a list of n nodes.
 * Each node is represented as a pair of [val, random_index] where:
 *      val: an integer representing Node.val
 *      random_index: the index of the node (range from 0 to n-1) that
 *      the random pointer points to, or null if it does not point to any node.
 * Your code will only be given the head of the original linked list.
 */
/*
Example 1:
Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

Example 2:
Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]
 */
public class CopyList {
    static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String headString = scanner.nextLine();
        headString = headString.replaceAll("\\[", "").replaceAll("]","");
        String[] headsArray = headString.split(",");
        CopyList copyList = new CopyList();
        Node head = copyList.createList(headsArray);
        Node copyHead = copyList.copyRandomList(head);
        while (copyHead != null && head != null){
            System.out.println("pre :");
            System.out.println("val = " + head.val
                    + ", next val = " + (head.next == null ? "null" : head.next.val)
                    + ", random val = " + (head.random == null ? "null" : head.random.val));
            System.out.println("past :");
            System.out.println("val = " + copyHead.val
                    + ", next val = " + (copyHead.next == null ? "null" : copyHead.next.val)
                    + ", random val = " + (copyHead.random == null ? "null" : copyHead.random.val));
            head = head.next;
            copyHead = copyHead.next;
        }
    }

    public Node createList(String[] headsArray) {
        int length = headsArray.length;
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < length; i += 2) {
            Node node = new Node(Integer.parseInt(headsArray[i]));
            nodes.add(node);
        }
        System.out.println(nodes.size());
        for (int i = 0; i < nodes.size(); ++i) {
           Node node = nodes.get(i);
           node.next = i < nodes.size() - 1 ? nodes.get(i + 1) : null;
           node.random = headsArray[2 * i + 1].equals("null") ? null : nodes.get(Integer.parseInt(headsArray[2 * i + 1]));
           nodes.set(i, node);
        }
        return nodes.get(0);
    }
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        List<Node> nodeList = new ArrayList<>();
        List<Node> nodes = new ArrayList<>();
        while (head!=null) {
            nodeList.add(head);
            nodes.add(new Node(head.val));
            head = head.next;
        }
        int length = nodes.size();
        for (int i = 0; i < length; ++i) {
            Node node = nodes.get(i);
            node.next = i < length - 1 ? nodes.get(i + 1) : null;
            node.random = nodeList.get(i).random == null ? null : nodes.get(nodeList.indexOf(nodeList.get(i).random));
            nodes.set(i,node);
        }
        return nodes.get(0);
    }
}
