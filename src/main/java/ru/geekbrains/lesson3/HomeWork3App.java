package ru.geekbrains.lesson3;

public class HomeWork3App {

    public static void main(String[] args) {
        method1();
        method2();
        method3();
        method4(5);
        int array[] = method5(4,15);

        minMax();
        int[] arrayCheck = {2, 2, 2, 1, 2, 2, 10, 1};
        checkBalance(arrayCheck);
    }


    private static void method1(){
        int[] array = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        for(int i = 0; i < array.length; i++){
            if(array[i] == 0){
                array[i]=1;
            }
            else{
                array[i] = 0;
            }
        }
    }
    private static void method2(){
        int[] array = new int[100];
        for(int i = 0; i < array.length; i++) {
            array[i]= i+1;
        }
    }

    private static void method3(){
        int[] array = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for(int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] = array[i] * 2;
            }
        }
    }

    private static void method4(int len) {
        int[][] array = new int[len][len];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(i == j)
                    array[i][j]=1;
                else {
                    if (i == count && (j == len - 1 - count))
                        array[i][j] = 1;
                }
            }
            count++;
        }

    }

    private static int[] method5(int len, int value){
        int []array = new int[len];
        for(int i = 0; i< array.length;i++)
            array[i]=value;
        return array;
    }

    private static void minMax(){
        int []array = new int[]{12,4,4,0,14,7,8,5};
        int min= array[0], max = array[0];
        for(int i = 1; i< array.length;i++){
            if(array[i] > max){
                max=array[i];
            }
            else
            if(array[i] < min){
                min=array[i];
            };
        }

        System.out.println("min = " + min  + "; max = " + max);

    }

    private static boolean checkBalance(int[] array){

        for(int counter = 1; counter< array.length - 1; counter++){

            int sumLeft = 0, sumRight = 0;
            for(int left = 0; left < counter; left++){
                sumLeft += array[left];
            }
            for(int right = array.length - 1; right >= counter; right--){
                sumRight += array[right];
            }

            if(sumLeft == sumRight)return true;
        }

        return false;
    }
}
