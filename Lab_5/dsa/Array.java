package Lab_5.dsa;

import java.util.Arrays;

public class Array {
    private int[] arr;
    private int size;

    public Array(int capacity) {
        arr = new int[capacity];
        size = 0;
    }

    public void insert(int element) {
        if (size < arr.length) {
            arr[size++] = element;
        } else {
            System.out.println("Array is full. Cannot insert element.");
        }
    }

    public void display() {
        System.out.println("Elements in the array:");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public boolean search(int element) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == element) {
                return true;
            }
        }
        return false;
    }

    public void sort() {
        Arrays.sort(arr, 0, size);
        System.out.println("Array sorted successfully.");
    }
}