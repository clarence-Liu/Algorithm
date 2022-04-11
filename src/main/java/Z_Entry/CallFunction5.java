package Z_Entry;

import Other.MyQueue;
import SlidingWindow.SummaryRanges;

public class CallFunction5 {
    public static void main(String[] args) {
        // 228. Summary Ranges
        System.out.println("228. Summary Ranges");
        SummaryRanges ranges = new SummaryRanges();
        System.out.println(Print.print(ranges.summaryRanges(new int[]{0,2,3,4,6,8,9})));;
        System.out.println();

        // 232. Implement Queue using Stacks
        System.out.println("232. Implement Queue using Stacks");
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek() + " , " + myQueue.pop() + " , " + myQueue.empty());
        System.out.println();
    }
}
