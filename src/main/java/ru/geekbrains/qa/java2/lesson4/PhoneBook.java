package ru.geekbrains.qa.java2.lesson4;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {

    private List<PhoneEntry> bookArray = new ArrayList();

    public void add(PhoneEntry entry){
        if(!this.bookArray.contains(entry))
            this.bookArray.add(entry);
    }

    public List get(String lastName){

        List<PhoneEntry> result = new ArrayList();
        for(PhoneEntry entry: this.bookArray){
            if(entry.getLastName().equals(lastName)){
                result.add(entry);
            }
        }
        return result;

    }




}
