#include <iostream>

class Base {
public:
    Base() {
        std::cout << "Base constructor called\n";
    }
    ~Base() {
        std::cout << "Base destructor called\n";
    }
};

class Derived : public Base {
public:
    Derived() {
        std::cout << "Derived constructor called\n";
    }
    ~Derived() {
        std::cout << "Derived destructor called\n";
    }
};

int main() {
    Derived derivedObj;
    return 0;
}
