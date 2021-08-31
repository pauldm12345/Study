package ru.geekbrains.lesson6;

public class Dog extends Animal{
    static final int MAX_RUN = 500;
    static final int MAX_SWIM = 10;
    static int countDogs = 0;

    public Dog(){
        super();
        countDogs++;
    }
    public void run(int m){
        if(m <= MAX_RUN){
            System.out.println("Собачка пробежала " + m + " м");
        }else{
            System.out.println("Собачка смогла пробежать " + MAX_RUN + " м");
        }
    }
    public void swim(int m){
        if(m <= MAX_SWIM){
            System.out.println("Собачка проплыла " + m + " м");
        }else{
            System.out.println("Собачка смогла проплыть " + MAX_RUN + " м");
        }

    }
    public int countDogs(){
        return countDogs;
    }
    public void printCountDogs(){
        System.out.println("Dogs count = " + countDogs);
    }
}
