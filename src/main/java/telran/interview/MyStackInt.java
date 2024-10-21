package telran.interview;

import java.util.ArrayDeque;
import java.util.EmptyStackException;

public class MyStackInt {
    private ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
    private ArrayDeque<Integer> maxArrayDeque = new ArrayDeque<>();

    public void push(int num) {
        // adds num into top of stack (last element)
        arrayDeque.add(num);
        int currentMax = getCurrentMax();
        if (num >= currentMax) {
            maxArrayDeque.add(num);
        } else {
            maxArrayDeque.add(currentMax);
        }
    }

    private int getCurrentMax() {
        int currentMax;
        try {
            currentMax = maxArrayDeque.getLast();
        } catch (Exception e) {
            currentMax = Integer.MIN_VALUE;
        }
        return currentMax;
    }

    public int pop() {
        // removes element from top of stack (last element)
        // returns being removed number
        // throws exception if the stack is empty
        int value;
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            value = arrayDeque.pollLast();
            int currentMax = getCurrentMax();
            if (value == currentMax) {
                maxArrayDeque.pollLast();
            }
        }
        return value;
    }

    public int peek() {
        // returns last number
        // throws exception if the stack is empty
        int value;
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            value = arrayDeque.peekLast();
        }
        return value;
    }

    public boolean isEmpty() {
        // returns true if the stack is empty, otherwise false
        return arrayDeque.isEmpty();
    }

    public int getMaxElement() {
        // returns the max number from the stack
        // throws exception if the stack is empty
        int value;
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            value = maxArrayDeque.peekLast();
        }
        return value;
    }

}
