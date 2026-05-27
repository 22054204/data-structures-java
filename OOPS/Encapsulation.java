package OOPS;

/*
 Encapsulation - Wrapping or Binding DATA + METHODS together in one unit (class)
                      and controlling direct access to data.
                 Instead of allowing anyone to change variables directly,
                    we hide them using private and access them using methods (getter/setter).
*/

class Person{
    // Private data members (attributes)
    private String name;
    private int age;
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    // Public methods to interact with the Person object

    // getter method for name
    public String getName() {
        return name;
    }
    // setter method for name
    public void setName(String name){
        this.name = name;
    }

    // getter method for age
    public int getAge(){
        return age;
    }
    // setter method for age
    public void setAge(int age){
        if(age>0) this.age = age;
        else System.out.println("Invalid age. Age must be greater than 0.");
    }
    public void display(){
        System.out.println("Name - " + name);
        System.out.println("Age - " + age);
    }
}
public class Encapsulation {
    static void main() {

        // create object
        Person obj = new Person("Ranjan", 20);

        // display result
        obj.display();

        //set name = Sharma
        obj.setName("Sharma");
        obj.display();

        // set age = 21
        obj.setAge(21);
        obj.display();
    }
}
