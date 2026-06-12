package OOPS.Polymorphism;

//Parent and child classes have the same method signature.

class Animal{
    void makeSound(){
        System.out.println("Some Sound");
    }
}
class Dog extends Animal{
    @Override
    void makeSound(){
        System.out.println("Bark");
    }
}
public class RunTime {
    static void main() {
        Animal obj1 = new Dog();
        obj1.makeSound();
    }
}
