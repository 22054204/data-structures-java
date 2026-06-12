package OOPS.Polymorphism;

// Same class, same method name, different parameters.

class Animal1{
    void makeSound(){
        System.out.println("Some Sound");
    }

    void makeSound(String animal1){
        System.out.println(animal1 + " Sound");
    }
}

public class CompileTime{
    public static void main(String[] args){
        Animal1 a = new Animal1();

        a.makeSound();
        a.makeSound("Dog");
    }
}
