package Lab_1;

import java.util.*;

public class Assignment_1_problem_1_iii {
    public static void main(String[] args) {
        int u = Integer.parseInt(args[0]);
        String[] s = new String[u];

        for (int i = 0; i < s.length; i++)
            s[i] = args[i + 1];
        Arrays.sort(s);
        System.out.println("The strings sorted lexicographically are as follows");
        for (int i = 0; i < s.length; i++)
            System.out.print(s[i] + " ");
        System.out.println();
    }
}
