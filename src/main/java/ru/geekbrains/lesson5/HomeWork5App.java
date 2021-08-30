package ru.geekbrains.lesson5;

public class HomeWork5App {

    public static void main(String[] args) {
        Employee array [] = new Employee[5];
        array[0] = new Employee("Ivan", "Ivanov", "Ivanovich",
                30, "Tester", 30000, "+7 678 890 56 78", "ert@mail.ru");

        array[1] = new Employee("Petr", "Petrov", "Petrovich",
                46, "Manager", 70000, "+7 678 890 56 78", "dft@hotmail.com");

        array[2] = new Employee("Serguy", "Sergyeev", "Serguyevich",
                31, "Manager", 39000, "+7 678 890 56 78", "sdf@yahoo.com");

        array[3] = new Employee("Oleg", "Olegov", "Olegovich",
                42, "CEO", 80000, "+7 678 890 56 78", "hju@hotmail.com");

        array[4] = new Employee("Alex", "Alexeev", "Alexandrovich",
                39, "Sales man", 50000, "+7 678 890 56 78", "lki@hotmail.com");

        for(int i = 0; i < array.length; i++){

            if(array[i].getAge() > 40)
                array[i].printMe();
        }
    }
}
