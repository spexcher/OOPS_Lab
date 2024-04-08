#include <bits/stdc++.h>

using namespace std;

class Employee
{
private:
    string name;
    int empNumber;
    char category;
    double salary;

public:
    Employee() {}
    Employee(string n, int num, char cat, double sal)
        : name(n), empNumber(num), category(cat), salary(sal) {}

    friend class Emanagement;

    void display() const
    {
        cout << "Name: " << name << endl;
        cout << "Employee Number: " << empNumber << endl;
        cout << "Category: " << category << endl;
        cout << "Salary: " << salary << endl;
    }
};

class Emanagement
{
private:
    vector<Employee> employees;

public:
    void assignInitialValues()
    {
        employees = {
            Employee("John", 101, 'A', 50000),
            Employee("Alice", 102, 'B', 40000),
            Employee("Bob", 103, 'C', 30000)};
    }

    void displayAll() const
    {
        for (const auto &emp : employees)
        {
            emp.display();
            cout << endl;
        }
    }

    void searchEmployee(int empNumber) const
    {
        auto it = find_if(employees.begin(), employees.end(), [empNumber](const Employee &emp)
                          { return emp.empNumber == empNumber; });

        if (it != employees.end())
        {
            it->display();
        }
        else
        {
            cout << "Employee with number " << empNumber << " not found." << endl;
        }
    }

    void arrangeByEmpNumber()
    {
        sort(employees.begin(), employees.end(), [](const Employee &a, const Employee &b)
             { return a.empNumber < b.empNumber; });
    }

    void insertEmployee(const Employee &emp)
    {
        employees.push_back(emp);
    }

    void deleteEmployee(int empNumber)
    {
        auto it = find_if(employees.begin(), employees.end(), [empNumber](const Employee &emp)
                          { return emp.empNumber == empNumber; });

        if (it != employees.end())
        {
            employees.erase(it);
            cout << "Employee with number " << empNumber << " deleted." << endl;
        }
        else
        {
            cout << "Employee with number " << empNumber << " not found." << endl;
        }
    }
};

int main()
{
    Emanagement em;
    em.assignInitialValues();

    int choice;
    do
    {
        cout << "Menu:\n1. Display all employees\n2. Search employee by employee number\n3. Arrange employees by employee number\n4. Insert new employee\n5. Delete employee\n6. Exit\nEnter your choice: ";
        cin >> choice;

        switch (choice)
        {
        case 1:
            cout << "All Employees:" << endl;
            em.displayAll();
            break;
        case 2:
            int empNum;
            cout << "Enter employee number to search: ";
            cin >> empNum;
            em.searchEmployee(empNum);
            break;
        case 3:
            em.arrangeByEmpNumber();
            cout << "Employees arranged by employee number." << endl;
            break;
        case 4:
        {
            string name;
            int empNumber;
            char category;
            double salary;
            cout << "Enter name, employee number, category, and salary of the employee to insert: ";
            cin >> name >> empNumber >> category >> salary;
            em.insertEmployee(Employee(name, empNumber, category, salary));
            cout << "Employee inserted successfully." << endl;
            break;
        }
        case 5:
        {
            int empNumToDelete;
            cout << "Enter employee number to delete: ";
            cin >> empNumToDelete;
            em.deleteEmployee(empNumToDelete);
            break;
        }
        case 6:
            cout << "Exiting program." << endl;
            break;
        default:
            cout << "Invalid choice. Please try again." << endl;
        }
    } while (choice != 6);

    return 0;
}
