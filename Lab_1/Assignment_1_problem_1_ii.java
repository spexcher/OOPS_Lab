package Lab_1;

public class Assignment_1_problem_1_ii {
    public static void main(String[] args) {
        if (args.length != 1)
            System.exit(1);
        String s = args[0];
        String rev = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            rev += s.charAt(i);
        }
        if (s.equals(rev)) {
            System.out.println("Yes " + rev + " is a pallinfromic entity");
        } else
            System.out.println("No " + rev + " is not a pallindromic entity");
    }
}
