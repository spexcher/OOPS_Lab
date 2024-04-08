#include <iostream>

class Base1 {
public:
    Base1() {
        std::cout << "Base1 constructor called\n";
    }
    ~Base1() {
        std::cout << "Base1 destructor called\n";
    }
};

class Base2 {
public:
    Base2() {
        std::cout << "Base2 constructor called\n";
    }
    ~Base2() {
        std::cout << "Base2 destructor called\n";
    }
};

class Derived : public Base1, public Base2 {
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
