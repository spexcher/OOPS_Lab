package Lab_1;

import java.util.*;

class Assignment_1_problem_1_i {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.exit(1);
        }
        int[] arr = new int[3];
        arr[0] = Integer.parseInt(args[0]);
        arr[1] = Integer.parseInt(args[1]);
        arr[2] = Integer.parseInt(args[2]);
        Arrays.sort(arr);
        System.out.println("The larges of the three numbers is " + arr[2]);
    }
}