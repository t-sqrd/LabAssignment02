/**
 * My implementation of a simple stack machine with pop and push functions.
 * The stack dynamically changes and updates size when pushing or popping.
 *
 * @author Tyson Craner
 */
class Stack {
    private String[] stack;

    Stack() {
        // initialize empty stack
        this.stack = new String[0];
    }

    // adds a string to the back of the stack
    void push(String toAdd) {
        String[] tempStack = new String[stack.length + 1];
        System.arraycopy(stack, 0, tempStack, 0, stack.length);
        tempStack[tempStack.length - 1] = toAdd;
        this.stack = tempStack;
    }

    // remove and return last item
    String pop() {
        String temp = stack[stack.length - 1];
        String[] tempStack = new String[stack.length - 1];
        if (stack.length - 1 >= 0) {
            System.arraycopy(stack, 0, tempStack, 0, stack.length - 1);
        }
        this.stack = tempStack;
        return temp;
    }

    // return the array format of stack
    String[] getArray() {
        return this.stack;
    }

    int length() {
        return this.stack.length;
    }
}
