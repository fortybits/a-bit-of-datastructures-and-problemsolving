package edu.bit.datastructures.stack;

import java.util.Stack;

/**
 * How would you design a stack which, in addition to push and pop, has a function min
 * which returns the minimum element? Push, pop and min should all operate in O(1)
 */
public class StackMinimum {
    Stack<Integer> actual;
    Stack<Integer> stack; // alternate stack used to store just the min

    public StackMinimum() {
        this.stack = new Stack<>();
    }

    public void pushValue(Integer value) {
        // push on alternate stack  if the value of min has changed
        if (value <= min()) {
            stack.push(value);
        }
        actual.push(value);
    }

    public Integer pop() {
        int val = actual.pop();
        if (val == min()) {
            stack.pop();
        }
        return val;
    }

    public int min() {
        if (stack.isEmpty()) {
            return Integer.MAX_VALUE; // error handling
        } else {
            return stack.peek();
        }
    }

    // we can solve it using a single stack itself by keeping a
    // track of the min value with insertion of each element into the stack
    class StackWithMin extends Stack<StackWithMin.NodeWithMin> {
        // you can keep a track of 'min' for every push and peek at O(1) cost
        // just that it would then consume O(n) space more
        public void push(int value) {
            int newMin = Math.min(value, min());
            super.push(new NodeWithMin(value, newMin));
        }

        private int min() {
            if (this.isEmpty()) {
                return Integer.MAX_VALUE; // error value
            } else {
                return peek().min;
            }
        }

        // used to update min with every push to keep the track of min with every element insertion
        class NodeWithMin {
            public int value;
            public int min;

            public NodeWithMin(int value, int min) {
                this.value = value;
                this.min = min;
            }
        }
    }
}
