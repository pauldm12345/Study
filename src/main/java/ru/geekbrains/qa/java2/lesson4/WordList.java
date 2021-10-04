package ru.geekbrains.qa.java2.lesson4;

import java.util.*;

public class WordList {

    ArrayList<String> array;

    public WordList(String [] nums){
        this.array = new ArrayList(Arrays.asList(nums));
    }

    public WordList(List list){
        this.array = new ArrayList(list);
    }

    public List getUniques(){

        List uniques = new ArrayList();
        for(String el: this.array){
            if(!uniques.contains(el)) uniques.add(el);
        }
        return uniques;
    }

    public HashMap countCases(){
        HashMap result = new HashMap();
        Collections.sort(this.array,String.CASE_INSENSITIVE_ORDER);
        int i = 0;
        for(Iterator it = this.array.iterator(); it.hasNext();){
            String s = (String) it.next();
            int n = 1;
            while((i+n < this.array.size()) && s.equalsIgnoreCase(this.array.get(i + n))){
                n++;
                it.next();
            }
            i= i+n;
            result.put(s, n);
        }
        return result;
    }


}
