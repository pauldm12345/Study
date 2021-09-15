package ru.geekbrains.qa.java2.lesson1;

import java.util.Scanner;

public class HomeWork1App {
    public static void main(String args[]){

        Course c = new Course(); // Создаем полосу препятствий

        String members[] = {"Bob", "Igor", "James", "Serguey"};

        Team team = new Team("My team", members); // Создаем команду

        Scanner scanner = new Scanner(System.in);
        String answer = "n";
        do{
            c.doIt(team); // Просим команду пройти полосу
            team.showResults(); // Показываем результаты
            team.showRun();

            System.out.println("Еще раз?");
            answer= scanner.next();
        }while (answer.equals("y"));
    }



}
