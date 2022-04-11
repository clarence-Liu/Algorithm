package Other;

import java.util.Stack;

/**
 * 232. Implement Queue using Stacks
 * <p>Implement a first in first out (FIFO) queue using only two stacks.
 * The implemented queue should support all the functions of a normal queue ({@code push}, {@code peek}, {@code pop}, and {@code empty}).
 *
 * <p>Implement the {@code MyQueue} class:
 * <ul>
 *     <li><tt>void push(int x)</tt> Pushes element x to the back of the queue.</li>
 *     <li><tt>int pop()</tt> Removes the element from the front of the queue and returns it.</li>
 *     <li><tt>int peek()</tt> Returns the element at the front of the queue.</li>
 *     <li><tt>boolean empty()</tt> Returns true if the queue is empty, false otherwise.</li>
 * </ul>
 * <p><strong>Notes:</strong>
 *
 * <li>You must use <strong>only</strong> standard operations of a stack, which means only {@code push to top}, {@code peek/pop} from {@code top}, {@code size}, and {@code is empty} operations are valid.</li>
 * <li>Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.</li>
 *
 * <p>Constraints:
 *
 * <li>1 <= x <= 9</li>
 * <li>At most 100 calls will be made to {@code push}, {@code peek}, {@code pop}, and {@code empty}.</li>
 * <li>All the calls to {@code pop} and {@code peek} are valid.</li>
 */
/*
Example 1:

Input
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 1, 1, false]

Explanation
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false
 */
public class MyQueue {
    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }
}
