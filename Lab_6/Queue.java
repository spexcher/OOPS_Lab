package Lab_6;

class Queue {
  private static final int MAX_SIZE = 5;
  private int[] array;
  private int front;
  private int rear;
  private int size;

  public Queue() {
      array = new int[MAX_SIZE];
      front = 0;
      rear = -1;
      size = 0;
  }

  public void insert(int item) throws MyException {
      if (size == MAX_SIZE) {
          throw new MyException("Queue overflow");
      }
      rear = (rear + 1) % MAX_SIZE;
      array[rear] = item;
      size++;
  }

  public int delete() throws MyException {
      if (size == 0) {
          throw new MyException("Underflow");
      }
      int deletedItem = array[front];
      front = (front + 1) % MAX_SIZE;
      size--;
      return deletedItem;
  }

  public void display() throws MyException {
      if (size == 0) {
          throw new MyException("Queue is empty");
      }
      System.out.print("Queue elements: ");
      int count = 0;
      int i = front;
      while (count < size) {
          System.out.print(array[i] + " ");
          i = (i + 1) % MAX_SIZE;
          count++;
      }
      System.out.println();
  }
}

