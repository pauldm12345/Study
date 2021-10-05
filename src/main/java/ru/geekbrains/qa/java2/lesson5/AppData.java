package ru.geekbrains.qa.java2.lesson5;

import java.util.ArrayList;
import java.util.Random;

public class AppData {
    private String[] header;
    private int[][] data;

    // ...
    public String[] getHeader() {return header;}
    public int[][] getData() {return data;}


    public static AppData generate(){

        Random random = new Random();
        AppData data = new AppData();

        data.header = new String[] {"Header1", "Header2","Header3","Header4","Header5"};
        int xsize = 5;
        int ysize = random.nextInt(100);
        data.data = new int[xsize][ysize];
        for(int i = 0; i < xsize; i++)
            for(int j = 0; j < ysize; j++){
                data.data[i][j]=random.nextInt(1000);
            }

        return data;
    }

    public void setValues(String [] header, ArrayList array){
        this.header = header;
        this.data = new int[this.header.length][array.size()];
        for(int j = 0; j < array.size(); j++){
            int []values = (int[])array.get(j);
            for(int i = 0 ; i < this.header.length; i++){
                this.data[i][j] = values[i];
            }
        }

    }

    public void print(){
        for(int i = 0; i < header.length; i++){
            System.out.print(header[i] + HomeWork5App.SEPARATOR);
        }
        System.out.println();

        for(int j = 0; j < data[0].length; j++){

            for(int i = 0 ; i < this.data.length; i++){
                System.out.print(this.data[i][j] + HomeWork5App.SEPARATOR);
            }
            System.out.println();
        }
    }

}