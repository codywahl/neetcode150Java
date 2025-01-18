package neetcode150java.Stack;

import java.util.Stack;

/**
 * Minimum Stack
 * Design a stack class that supports the push, pop, top, and getMin operations.
 * 
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * Each function should run in
 * O
 * (
 * 1
 * )
 * O(1) time.
 * 
 * Example 1:
 * 
 * Input: ["MinStack", "push", 1, "push", 2, "push", 0, "getMin", "pop", "top",
 * "getMin"]
 * 
 * Output: [null,null,null,null,0,null,2,1]
 * 
 * Explanation:
 * MinStack minStack = new MinStack();
 * minStack.push(1);
 * minStack.push(2);
 * minStack.push(0);
 * minStack.getMin(); // return 0
 * minStack.pop();
 * minStack.top(); // return 2
 * minStack.getMin(); // return 1
 * Constraints:
 * 
 * -2^31 <= val <= 2^31 - 1.
 * pop, top and getMin will always be called on non-empty stacks.
 */
public class MinStack {
    Stack<Integer> valueStack;
    Stack<Integer> minStack;
    int currentMinimum;
    int length;

    public MinStack() {
        this.valueStack = new Stack<>();
        this.minStack = new Stack<>();
        this.currentMinimum = Integer.MAX_VALUE;
        this.length = 0;
    }

    // void push(int val) pushes the element val onto the stack.
    public void push(int value) {
        if (length == 0) {
            currentMinimum = value;
        } else {
            currentMinimum = Math.min(currentMinimum, value);
        }

        valueStack.push(value);
        minStack.push(currentMinimum);
        length++;
    }

    // void pop() removes the element on the top of the stack.
    public void pop() {
        if (length > 0) {
            length--;
            valueStack.pop();
            minStack.pop();
        }
    }

    // int top() gets the top element of the stack.
    public int top() {
        if (length > 0) {
            return valueStack.peek();
        } else
            throw new RuntimeException("Stack is empty");
    }

    // int getMin() retrieves the minimum element in the stack.
    public int getCurrentMinimum() {
        if (length > 0) {
            return minStack.peek();
        } else
            throw new RuntimeException("Stack is empty");
    }
}
