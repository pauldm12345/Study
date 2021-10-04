package ru.geekbrains.qa.java2.lesson3;

public class HomeWork3App {

    public static void main(String [] args){
        MyArray<Integer> array = new MyArray<Integer> (1,2,3,4,5,6,7);
        array.exchange(3,4);
        for(Integer i : array.getArray()){
            System.out.print(i + ",");
        }
        System.out.println("");

        //////////
        FruitBox<Orange> orangeBox = new FruitBox(new Orange[] {new Orange(), new Orange(), new Orange()});
        FruitBox<Orange> orangeBox2 = new FruitBox(new Orange[] {new Orange(), new Orange(), new Orange(), new Orange(), new Orange(), new Orange()});
        FruitBox<Apple> appleBox = new FruitBox(new Apple[] {new Apple(), new Apple(), new Apple()});
        FruitBox<Apple> appleBox2 = new FruitBox(new Apple[] {new Apple(), new Apple(), new Apple()});

        System.out.println(orangeBox.getWeight());
        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.compare(appleBox));

        System.out.println(orangeBox.getBox().size());
        for (int i = 0; i < 5; i++){
            orangeBox.addFruit(new Orange());
        }
        System.out.println(orangeBox.getBox().size());

        orangeBox.moveTo(orangeBox2);
        appleBox.moveTo(appleBox2);

        orangeBox2.moveTo(appleBox2);

    }
}
