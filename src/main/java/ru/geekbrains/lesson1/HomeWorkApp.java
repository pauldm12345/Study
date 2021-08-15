package ru.geekbrains.lesson1;

public class HomeWorkApp {
    public static void main(String[] args) {

        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    private static void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    private static void checkSumSign(){
        int a = 10, b=-20;
        if((a+b) > 0){
            System.out.println("Sum is positive");
        }
        else{
            System.out.println("Sum is negative");
        }
    }

    private static void printColor(){
        int value = 255;
        if(value <= 0){
            System.out.println("RED");
        }
        else {
            if (value <= 100){
                System.out.println("YELLOW");
            }
            else{
                System.out.println("GREEN");
            }
        }
    }

    private static void compareNumbers(){
        int a=10, b = 100;
        if(a >= b){
            System.out.println(a + " >= " + b);
        }
        else{
            System.out.println(a + " < " + b);
        }
    }
}
