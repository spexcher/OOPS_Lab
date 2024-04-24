package Lab_6;

class Default {
    void display() {
        System.out.println("This is a default access specifier");
    }
}

class Assignment_6_problem_2 {
    public static void main(String[] args) {
        AccessingSpecifier obj = new AccessingSpecifier();

        // Accessing public method
        obj.publicMethod();

        // Accessing private method (Not allowed outside the class)
        // obj.privateMethod(); // Compilation error

        // Accessing protected method
        obj.protectedMethod();

        // Accessing default method
        obj.defaultMethod();

        // obj.private_variable = 6; //
        // this causes error
        obj.public_variable = 6; //
        System.out.println("Public variable: " + obj.public_variable);

        obj.protected_variable = 32; //
        System.out.println("Protected variable: " + obj.protected_variable);

        // Accessing class with default access specifier (within the same package)
        Default defaultAccessSpecifier = new Default();
        defaultAccessSpecifier.display();
    }
}
