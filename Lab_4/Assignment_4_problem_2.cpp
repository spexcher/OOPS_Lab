#include <iostream>
#include <stdexcept>
using namespace std;

class Queue
{
public:
    virtual void enqueue(int element) = 0;
    virtual int dequeue() = 0;
    virtual int peek() const = 0;
    virtual bool isEmpty() const = 0;
    virtual bool isFull() const = 0;
};

class LinearQueue : public Queue
{
private:
    int *array;
    int front;
    int rear;
    int capacity;

public:
    LinearQueue(int size) : capacity(size)
    {
        array = new int[capacity];
        front = rear = -1;
    }

    ~LinearQueue()
    {
        delete[] array;
    }

    void enqueue(int element) override
    {
        if (isFull())
        {
            throw std::runtime_error("Queue is full");
        }
        if (isEmpty())
        {
            front = 0;
        }
        rear = (rear + 1) % capacity;
        array[rear] = element;
    }

    int dequeue() override
    {
        if (isEmpty())
        {
            throw std::runtime_error("Queue is empty");
        }
        int element = array[front];
        if (front == rear)
        {
            front = rear = -1;
        }
        else
        {
            front = (front + 1) % capacity;
        }
        return element;
    }

    int peek() const override
    {
        if (isEmpty())
        {
            throw std::runtime_error("Queue is empty");
        }
        return array[front];
    }

    bool isEmpty() const override
    {
        return front == -1;
    }

    bool isFull() const override
    {
        return (rear + 1) % capacity == front;
    }
};

class CircularQueue : public Queue
{
private:
    int *array;
    int front;
    int rear;
    int capacity;

public:
    CircularQueue(int size) : capacity(size)
    {
        array = new int[capacity];
        front = rear = -1;
    }

    ~CircularQueue()
    {
        delete[] array;
    }

    void enqueue(int element) override
    {
        if (isFull())
        {
            throw std::runtime_error("Queue is full");
        }
        if (isEmpty())
        {
            front = 0;
        }
        rear = (rear + 1) % capacity;
        array[rear] = element;
    }

    int dequeue() override
    {
        if (isEmpty())
        {
            throw std::runtime_error("Queue is empty");
        }
        int element = array[front];
        if (front == rear)
        {
            front = rear = -1;
        }
        else
        {
            front = (front + 1) % capacity;
        }
        return element;
    }

    int peek() const override
    {
        if (isEmpty())
        {
            throw std::runtime_error("Queue is empty");
        }
        return array[front];
    }

    bool isEmpty() const override
    {
        return front == -1;
    }

    bool isFull() const override
    {
        return (rear + 1) % capacity == front;
    }
};

int main()
{
    LinearQueue linearQueue(5);
    CircularQueue circularQueue(5);
    Queue *ref = nullptr;

    cout << "Choose the type of queue: \n1. LinearQueue\n2. CircularQueue\n";
    int choice;
    cin >> choice;

    switch (choice)
    {
    case 1:
        ref = &linearQueue;
        break;
    case 2:
        ref = &circularQueue;
        break;
    default:
        cout << "Invalid choice" << endl;
        return 1;
    }

    cout << "Queue operations: \n";
    ref->enqueue(1);
    ref->enqueue(2);
    ref->enqueue(3);

    while (!ref->isEmpty())
    {
        cout << ref->dequeue() << " ";
    }
    cout << endl;

    return 0;
}
