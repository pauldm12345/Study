package ru.geekbrains.qa.java2.lesson5;

import java.io.*;
import java.util.ArrayList;

public class HomeWork5App {

    public static final String FILE_PATH = "myfile.csv";
    public static final String SEPARATOR = ";";

    public static void main(String [] args){

       AppData data = AppData.generate();

       writeCSV(data);

       AppData data1 = readCSV();

       data1.print();
    }

    public static AppData readCSV(){
        AppData data = null;
        try (BufferedReader in = new BufferedReader(new FileReader(FILE_PATH))) {

            data = new AppData();
            String result = in.readLine(); // header

            String[] header = result.split(SEPARATOR);

            ArrayList array = new ArrayList();

            while ((result = in.readLine()) != null) {
                String[]tokens = result.split(SEPARATOR);
                int[] values = new int[tokens.length];
                for(int i = 0; i < values.length; i++){
                    values[i]= Integer.parseInt(tokens[i]);
                }
                array.add(values);
            }
            in.close();

            data.setValues(header, array);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;

    }

    public static void writeCSV(AppData data){
        try (BufferedWriter out = new BufferedWriter(new FileWriter(FILE_PATH))) {
            String line="";
            //header
            String [] header = data.getHeader();
            for(int i = 0; i < header.length;i++) line += header[i] + SEPARATOR;
            out.write(line + "\r");

            int[][]values = data.getData();
            int ysize = values[0].length;
            for (int j = 0; j < ysize; j++) {
                line ="";
                for(int i = 0; i < values.length;i++){
                    line += values[i][j] + SEPARATOR;
                }
                out.write(line+ "\r");
            }

            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
