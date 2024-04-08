package Lab_4;

import java.util.Scanner;

interface Stack {
    void push(int element);

    int pop();

    int peek();

    boolean isEmpty();

    boolean isFull();
}

class StaticStack implements Stack {
    private int[] array;
    private int top;
    private int capacity;

    public StaticStack(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
        top = -1;
    }

    public void push(int element) {
        if (isFull()) {
            throw new RuntimeException("Stack is full");
        }
        array[++top] = element;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return array[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return array[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }
}

class DynamicStack implements Stack {
    private int[] array;
    private int top;
    private static final int DEFAULT_CAPACITY = 10;

    public DynamicStack() {
        this(DEFAULT_CAPACITY);
    }

    public DynamicStack(int initialCapacity) {
        array = new int[initialCapacity];
        top = -1;
    }

    public void push(int element) {
        if (isFull()) {
            resize();
        }
        array[++top] = element;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return array[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return array[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == array.length - 1;
    }

    private void resize() {
        int newSize = array.length * 2;
        int[] newArray = new int[newSize];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }
}

public class Assignment_4_problem_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack stack = null;
    
        System.out.println("Choose the type of stack:");
        System.out.println("1. StaticStack");
        System.out.println("2. DynamicStack");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                stack = new StaticStack(5);
                break;
            case 2:
                stack = new DynamicStack();
                scanner.close();
                break;
            default:
                System.out.println("Invalid choice");
                scanner.close();
                return;
        }

        stack.push(1);
        stack.push(2);
        stack.push(3);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }
}
