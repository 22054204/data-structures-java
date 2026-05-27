package OOPS;

/*

CLASS :
A class is a blueprint or template used to create objects.
It defines what data an object will store and what actions it can perform.

OBJECT :
An object is a real instance of a class.
It occupies memory and can access the data and methods of the class.

Real-life Example:
Class  -> Car blueprint 🚗
Object -> Actual cars created from that blueprint

*/

class Car {
    // Attributes (data members)
    String model;
    int year;

    // Method
    void start(){
        System.out.println(model + " is starting.");
    }
}

// Creating instances(objects) of the class
public class ClassAndObjects {
    public static void main(String[] args) {
        // Creating two objects of Car class
        Car car1 = new Car();
        Car car2 = new Car();

        // Setting attributes for car1
        car1.model = "Toyota";
        car1.year = 2022;

        // Setting attributes for car2
        car2.model = "Honda";
        car2.year = 2023;

        // Accessing object data
        System.out.println(car1.model + " " + car1.year);
        System.out.println(car2.model + " " + car2.year);

        // Calling methods using objects
        car1.start();
        car2.start();
    }
}