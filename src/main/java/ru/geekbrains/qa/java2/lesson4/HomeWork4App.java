package ru.geekbrains.qa.java2.lesson4;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HomeWork4App {

    public static void main(String [] args){

        WordList myList = new WordList(Arrays.asList("Orange", "White", "Blue", "Purple", "Green", "White",  "Navy", "Red",
                                                        "Yellow", "Brown", "Black", "Purple", "Green",  "White", "Purple",
                                                        "Green", "White"));


        List<String> uniques = myList.getUniques();
        System.out.println("Count uniques " + uniques.size());
        for(String u: uniques){
            System.out.print(u + ",");
        }
        System.out.println();

        HashMap<String, Integer> cases = myList.countCases();
        for(String s : cases.keySet()){
            System.out.println(s + " = " + cases.get(s));
        }


        /////

        PhoneBook book = new PhoneBook();

        book.add(new PhoneEntry("Ivanov", "+7 495 678 99 90"));
        book.add(new PhoneEntry("Ivanov", "+7 495 789 99 90"));
        book.add(new PhoneEntry("Petrov", "+7 333 789 99 90"));

        List result = book.get("Ivanov");

        System.out.println(result);
    }




}
