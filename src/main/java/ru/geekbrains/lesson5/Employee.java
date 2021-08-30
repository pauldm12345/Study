package ru.geekbrains.lesson5;

public class Employee {
    private String firstName;
    private String lastName;
    private String surName;
    private int age;
    private String position;
    private int salary;
    private String phone;
    private String email;


    public Employee(){
        ;
    }
    public Employee(String firstName,
            String lastName,
            String surName,
            int age,
            String position,
            int salary,
            String phone, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.surName = surName;
        this.age = age;
        this.phone = phone;
        this.position = position;
        this.salary = salary;
        this.email = email;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }

    public int getSalary(){
        return salary;
    }
    public void setSalary(int salary){
        this.salary = salary;
    }

    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getSurName(){
        return surName;
    }
    public void setSurName(String surName){
        this.surName = surName;
    }
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPosition(){
        return position;
    }
    public void setPosition(String position){
        this.position = position;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public void printMe(){

        System.out.println("Name: " + firstName + " LastName: " + lastName + " Surname: " + surName);
        System.out.println("age: " + age + " salary: " + salary + " Position: " + position);
        System.out.println("Phone: " + phone + " email: " + email);

    }
}
