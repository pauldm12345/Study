package ru.geekbrains.lesson2;

public class HomeWork2App {

    public static void main(String[] args) {

        System.out.println ("100 -90 " + IntegerParams(100, -90));

        intPosOrNeg(100);
        System.out.println ("-70 " + boolPosOrNeg(-70));
        printMyString(3, "Hello");

        //test
        System.out.println("21 " + leapYear(2021));
        System.out.println("22 " + leapYear(2022));
        System.out.println("23 " + leapYear(2023));
        System.out.println("24 " + leapYear(2024));
        System.out.println("2000 " + leapYear(2000));
        System.out.println("1900 " + leapYear(1900));


    }

    private static boolean IntegerParams(int a, int b){
        int c = a+ b;
        if((10 <= c) && (c <= 20)){
            return true;
        }
        else{
            return false;
        }
    }

    private static void intPosOrNeg(int a){
        if(a >= 0){
            System.out.println(a + " positive");
        }
        else{
            System.out.println(a + "negative");
        }
    }
    private static boolean boolPosOrNeg(int a){
        if(a >= 0){
            //приравняла ноль к позитивным как и в прошлом методе
            //если ноль не считать позитивным то тогда строго больше нуля
            return true;
        }
        else{
            return false;
        }
    }

    private static void printMyString(int a, String S){
        if(a > 5000) return;// не печатать если очень много повторов

        for(int i = 0; i < a; i++){
            System.out.println(S);
        }
    }


    private static boolean leapYear(int currentYear){

        if ((currentYear - ((int)(currentYear / 400)) * 400) == 0){
            //every 400th year - is a leap year
            return true;
        }
        else if((currentYear - ((int)(currentYear / 100)) * 100) == 0){
            //not a leap year
            // every 100-th year
            return false;
        }

        else{
            boolean isLeapYear = (currentYear - ((int)(currentYear / 4)) * 4) == 0;
            return(isLeapYear);
        }
    }
}
