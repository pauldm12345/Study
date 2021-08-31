package ru.geekbrains.lesson6;

public class HomeWork6App {

    public static void main (String[] args){
        Cat cat = new Cat();
        Dog dog = new Dog();

        cat.run(25);
        cat.swim(10);
        dog.run(34);
        dog.swim(5);

        cat.printCountCats();
        dog.printCountDogs();
        cat.printCount();
    }
}
