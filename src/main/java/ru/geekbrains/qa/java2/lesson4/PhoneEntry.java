package ru.geekbrains.qa.java2.lesson4;

public class PhoneEntry extends Object{
    private String lastName;
    private String phone;
    public PhoneEntry(String lastName, String phone){
        this.lastName = lastName;
        this.phone = phone;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getPhone(){
        return this.phone;
    }

    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj instanceof PhoneEntry){
            PhoneEntry entry = (PhoneEntry) obj;
            return this.phone.equals(entry.phone) && this.lastName.equals(entry.lastName);
        }
        return false;
    }
}