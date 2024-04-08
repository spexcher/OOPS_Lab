#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Hotel
{
protected:
    string hotelName;
    string hotelType;
    string city;
    double hotelRate;

public:
    Hotel(const string &name, const string &type, const string &city, double rate)
        : hotelName(name), hotelType(type), city(city), hotelRate(rate) {}

    virtual ~Hotel() {}

    virtual void display() const
    {
        cout << "Hotel Name: " << hotelName << endl;
        cout << "Hotel Type: " << hotelType << endl;
        cout << "City: " << city << endl;
        cout << "Rate: " << hotelRate << endl;
    }
};

class Flight
{
public:
    string flightNo;
    string sourceCity;
    string destinationCity;
    int seatNo;

public:
    Flight(const string &flightNo, const string &source, const string &destination, int seat)
        : flightNo(flightNo), sourceCity(source), destinationCity(destination), seatNo(seat) {}

    virtual ~Flight() {}

    virtual void display() const
    {
        cout << "Flight No: " << flightNo << endl;
        cout << "Source City: " << sourceCity << endl;
        cout << "Destination City: " << destinationCity << endl;
        cout << "Seat No: " << seatNo << endl;
    }
};

class Passenger : public Hotel, public Flight
{
private:
    string name;
    int age;

public:
    Passenger(const string &name, int age, const string &city,
              const string &hotelName, const string &hotelType, const string &hotelCity, double hotelRate,
              const string &flightNo, const string &source, const string &destination, int seat)
        : Hotel(hotelName, hotelType, hotelCity, hotelRate),
          Flight(flightNo, source, destination, seat),
          name(name), age(age) {}

    void display() const override
    {
        cout << "Passenger Name: " << name << endl;
        cout << "Age: " << age << endl;
        Hotel::display();
        Flight::display();
    }
};

int main()
{
    vector<Passenger> passengers;
    int choice;

    do
    {
        cout << "Menu:" << endl;
        cout << "1. Input details of all passengers" << endl;
        cout << "2. Display the details of all passengers" << endl;
        cout << "3. Display the details of all passengers for a particular flight" << endl;
        cout << "4. Exit" << endl;
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice)
        {
        case 1:
        {
            string name, city, hotelName, hotelType, hotelCity, flightNo, source, destination;
            int age;
            double hotelRate;
            int seat;

            cout << "Enter passenger name: ";
            fflush(stdout);
            fflush(stdin);
            cin >> name;
            cout << "Enter age: ";
            fflush(stdout);
            fflush(stdin);
            cin >> age;
            cout << "Enter city: ";
            fflush(stdout);
            fflush(stdin);
            cin >> city;
            cout << "Enter hotel name: ";
            fflush(stdout);
            fflush(stdin);
            cin >> hotelName;
            cout << "Enter hotel type: ";
            fflush(stdout);
            fflush(stdin);
            cin >> hotelType;
            cout << "Enter hotel city: ";
            fflush(stdout);
            fflush(stdin);
            cin >> hotelCity;
            cout << "Enter hotel rate: ";
            fflush(stdout);
            fflush(stdin);
            cin >> hotelRate;
            cout << "Enter flight no: ";
            fflush(stdout);
            fflush(stdin);
            cin >> flightNo;
            cout << "Enter source city: ";
            fflush(stdout);
            fflush(stdin);
            cin >> source;
            cout << "Enter destination city: ";
            fflush(stdout);
            fflush(stdin);
            cin >> destination;
            cout << "Enter seat no: ";
            fflush(stdout);
            fflush(stdin);
            cin >> seat;

            passengers.emplace_back(name, age, city, hotelName, hotelType, hotelCity, hotelRate,
                                    flightNo, source, destination, seat);
            break;
        }
        case 2:
        {
            if (passengers.empty())
            {
                cout << "No passengers to display." << endl;
            }
            else
            {
                cout << "Details of all passengers:" << endl;
                for (const Passenger &passenger : passengers)
                {
                    passenger.display();
                    cout << endl;
                }
            }
            break;
        }
        case 3:
        {
            string flightNo;
            cout << "Enter flight no: ";
            cin >> flightNo;

            bool found = false;
            for (const Passenger &passenger : passengers)
            {
                if (passenger.Flight::flightNo == flightNo)
                {
                    passenger.display();
                    cout << endl;
                    found = true;
                }
            }
            if (!found)
            {
                cout << "No passengers found for flight " << flightNo << endl;
            }
            break;
        }
        case 4:
            cout << "Exiting..." << endl;
            break;
        default:
            cout << "Invalid choice. Please try again." << endl;
        }
    } while (choice != 4);

    return 0;
}
