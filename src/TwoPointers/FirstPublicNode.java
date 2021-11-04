package TwoPointers;

public class FirstPublicNode {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        int countA = 0, countB = 0;
        while(p != null) {
            countA++;
            p = p.next;
        }
        while(q != null) {
            countB++;
            q = q.next;
        }
        int diff = countA > countB ? countA - countB : countB - countA;
        p = headA;
        q = headB;
        if (countA > countB) {
            while (diff > 0) {
                diff--;
                p = p.next;
            }
        } else {
            while (diff > 0) {
                diff--;
                q = q.next;
            }
        }
        while (p != q) {
            p = p.next;
            q = q.next;
        }
        return p;
    }
}
