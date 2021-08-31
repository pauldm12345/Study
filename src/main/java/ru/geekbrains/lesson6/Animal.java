package ru.geekbrains.lesson6;

public abstract class Animal {
    static int count = 0;

    public abstract void run(int m);
    public abstract void swim(int m);

    public Animal(){
        count++;
    }
    public int count(){
        return count;
    }
    public void printCount(){
        System.out.println("Animal count = " + count);
    }

}
