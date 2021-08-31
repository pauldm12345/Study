package ru.geekbrains.lesson6;

public class Cat extends Animal{
    static final int MAX_RUN = 200;
    //static final int MAX_SWIM = 0;
    static int countCats =0;

    public Cat(){
        super();
        countCats++;
    }
    public void run(int m){
        if(m <= MAX_RUN){
            System.out.println("Котик промчался " + m + " км");
        }else{
            System.out.println("Котик смог пробежать " + MAX_RUN + " км");
        }
    }
    public void swim(int m){
        System.out.println("Котик не умеет плавать !");
    }
    public int countCats(){
        return countCats;
    }
    public void printCountCats(){
        System.out.println("Cats count = " + countCats);
    }
}
