package ru.geekbrains.qa.java2.lesson2;

import java.util.Random;

public class HomeWork2App {
    public static void main(String[] args){


        String [][] array = new String [4][4];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = "" + random.nextInt();
            }
        }

        /*
        String [][] array = {
                {"23", "24", "56", "hello"},
                {"23", "24", "56", "hello"},
                {"23", "24", "56", "hello"},
                {"23", "24", "56", "hello"}
        };
        */


        try{
            checkArrayLength(array);
        }
        catch(MyArraySizeException e){
            e.printStackTrace();
            return;
        }


        try{

            System.out.println(convertArrayToInteger(array));

        }
        catch(MyArrayDataException e){
            e.printStackTrace();

        }
    }

    private static void checkArrayLength(String [][] array) throws MyArraySizeException{

        if(array == null){
            throw new MyArraySizeException("Массив null");
        }
        else{
            if(array.length == 4) {
                for (int i = 0; i < array.length; i++) {
                    if(array[i] == null || array[i].length != 4){
                        throw new MyArraySizeException("Массив должен быть размером 4Х4");
                    }
                }
            }
            else{
                throw new MyArraySizeException("Массив должен быть размером 4Х4");
            }
        }
    }

    private static int convertArrayToInteger(String [][] array) throws MyArrayDataException{
        int [][] result = new int[4][4];
        int r = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    result[i][j] = Integer.parseInt(array[i][j]);
                    r += result[i][j];
                }
                catch(NumberFormatException e){
                    throw new MyArrayDataException(i, j);
                }
            }
        }

        return r;

    }
}
