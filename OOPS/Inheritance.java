package OOPS;

/*

Inheritance
    Definition: Inheritance is an OOP concept in which one class acquires the properties and methods of another class.

Purpose:    Code Reusability
            Reduces duplicate code
            Establishes an IS-A relationship between classes

Syntax:  class Child extends Parent

*/

class Parent{
    double height;
    double weight;
    String color;
}
class Child extends Parent{
    String type; // weak/mid/smart
    String gender;
    Child(String type, String gender, double height, double weight, String color){
        this.height = height;
        this.type = type;
        this.gender = gender;
        this.weight = weight;
        this.color = color;
    }
    public void Display(){
        System.out.println("type - "+type);
        System.out.println("gender - "+gender);
        System.out.println("height - "+height);
        System.out.println("weight - "+weight);
        System.out.println("color - "+color);
    }
}

public class Inheritance {
    static void main() {
        Child obj = new Child("Smart", "Male", 5.8, 82.5, "Fair");
        obj.Display();
    }
}



/*
// also done using SUPER Keyword

            //super();  // parent constructor
            //this();   // another constructor of same class

package OOPS;

class Parent{
    double height;
    double weight;
    String color;

// Give Parent its own constructor
    Parent(double height, double weight, String color){
        this.height = height;
        this.weight = weight;
        this.color = color;
    }
}

class Child extends Parent{
    String type;
    String gender;

    Child(String type, String gender, double height, double weight, String color){
        super(height, weight, color);
        this.type = type;
        this.gender = gender;
    }

    void display(){
        System.out.println("Type - " + type);
        System.out.println("Gender - " + gender);
        System.out.println("Height - " + height);
        System.out.println("Weight - " + weight);
        System.out.println("Color - " + color);
    }
}

public class Inheritance{
    static void main(){
        Child obj = new Child("Smart", "Male", 5.8, 82.5, "Fair");
        obj.display();
    }
}
 */
