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

class Derived1 : public Base {
public:
    Derived1() {
        std::cout << "Derived1 constructor called\n";
    }
    ~Derived1() {
        std::cout << "Derived1 destructor called\n";
    }
};

class Derived2 : public Base {
public:
    Derived2() {
        std::cout << "Derived2 constructor called\n";
    }
    ~Derived2() {
        std::cout << "Derived2 destructor called\n";
    }
};

int main() {
    Derived1 derivedObj1;
    Derived2 derivedObj2;
    return 0;
}
