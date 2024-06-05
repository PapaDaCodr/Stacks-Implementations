package com.OseiOwusuAnsah.Assignment1;
public class ArrayStack<T> implements StackADT<T> {
    private static final int DEFAULT_CAPACITY = 100;
    private int top;
    private T[] stack;

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(int initialCapacity) {
        stack = (T[]) new Object[initialCapacity];
        top = -1;
    }

    @Override
    public void push(T element) {
        if (top == stack.length - 1) {
            expandCapacity();
        }
        stack[++top] = element;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T element = stack[top];
        stack[top--] = null;
        return element;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i <= top; i++) {
            sb.append(stack[i]);
            if (i < top) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private void expandCapacity() {
        T[] newStack = (T[]) new Object[stack.length * 2];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();

        // Test push
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack after pushing: " + stack); // [1, 2, 3]

        // Test pop
        int poppedElement = stack.pop();
        System.out.println("Popped element: " + poppedElement); // 3
        System.out.println("Stack after popping: " + stack); // [1, 2]

        // Test peek
        int topElement = stack.peek();
        System.out.println("Top element: " + topElement); // 2
        System.out.println("Stack after peeking: " + stack); // [1, 2]

        // Test isEmpty
        System.out.println("Is stack empty? " + stack.isEmpty()); // false

        // Test size
        System.out.println("Stack size: " + stack.size()); // 2

        try {
            stack.pop();
        } catch (IllegalStateException e) {
            System.out.println("Exception caught: " + e.getMessage()); // Stack is empty
        }

        // Test peek on empty stack
        try {
            stack.peek();
        } catch (IllegalStateException e) {
            System.out.println("Exception caught: " + e.getMessage()); // Stack is empty
        }

        // Test isEmpty on empty stack
        try {
            stack.pop();
            stack.pop();
            System.out.println("Is stack empty? " + stack.isEmpty()); // true
        } catch (IllegalStateException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}