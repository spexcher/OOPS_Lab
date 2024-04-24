package Lab_6.dsa;
import java.util.Arrays;

public class LinkedList {
    private Node head;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedList() {
        this.head = null;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public boolean search(int item) {
        Node current = head;
        while (current != null) {
            if (current.data == item) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void insert(int item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void delete(int item) {
        if (head == null) {
            return;
        }
        if (head.data == item) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data == item) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public void sort() {

        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }

        int[] arr = new int[count];
        current = head;
        for (int i = 0; i < count; i++) {
            arr[i] = current.data;
            current = current.next;
        }

        Arrays.sort(arr);

        current = head;
        for (int i = 0; i < count; i++) {
            current.data = arr[i];
            current = current.next;
        }
    }
}