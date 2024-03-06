package Lab_1;

class Assignment_1_problem_1 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.exit(1);
        }
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.println(a + b);
    }
}