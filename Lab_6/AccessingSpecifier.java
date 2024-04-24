package Lab_6;
class AccessingSpecifier {
  // data members with multiple types of access specifiers
  public int public_variable;
  private int private_variable;
  protected int protected_variable;
  // Public method
  public void publicMethod() {
      System.out.println("This is a public method");
  }
  public void privatesetter(int yu){
    this.private_variable = yu;
  }
  public int privategetter(int yu){
    return this.private_variable;
  }

  // Private method

  // Protected method
  protected void protectedMethod() {
      System.out.println("This is a protected method");
  }

  // default access specifier 
  void defaultMethod() {
      System.out.println("This is a default access specifier method");
  }
 }