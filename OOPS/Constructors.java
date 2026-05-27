package OOPS;

/*
CONSTRUCTOR :

A constructor is a special method used to initialize objects.
It is automatically called when an object is created.

Rules of Constructor:
1. Constructor name must be same as class name
2. Constructor does not have any return type
3. Constructor is called automatically during object creation

------------------------------------------------------------

TYPES OF CONSTRUCTORS :

1. Default Constructor
   -> Constructor with no parameters
2. Parameterized Constructor
   -> Constructor with parameters to initialize values

------------------------------------------------------------
*/

class Student
{
    String name;
    int age;

    // Default Constructor
    Student()
    {
        name = "Unknown";
        age = 0;

        System.out.println("Default Constructor Called");
    }

    // Parameterized Constructor
    Student(String n, int a)
    {
        name = n;
        age = a;

        System.out.println("Parameterized Constructor Called");
    }

    void display()
    {
        System.out.println("NAME : " + name);
        System.out.println("AGE  : " + age);
    }
}

public class Constructors
{
    public static void main(String[] args)
    {
        // Calling Default Constructor
        Student s1 = new Student();
        s1.display();

        // Calling Parameterized Constructor
        Student s2 = new Student("Ranjan", 20);
        s2.display();
    }
}