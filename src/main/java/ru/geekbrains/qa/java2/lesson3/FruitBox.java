package ru.geekbrains.qa.java2.lesson3;

import java.util.ArrayList;

public class FruitBox<T extends Fruit> {

    private ArrayList< Fruit> box;

    public FruitBox(T[] nums) {
        this.box= new ArrayList();
        for(Fruit f : nums) this.box.add(f);
    }

    public ArrayList<Fruit> getBox(){
        return box;
    }
    public double getWeight(){
        double weight = 0;
        for(Fruit f : box){
            weight += f.getWeight();
        }
        return weight;
    }

    public boolean compare(FruitBox anotherBox){
        return getWeight() == anotherBox.getWeight();
    }

    public boolean isEmpty(){
        if(box == null || box.size()==0) return true;
        return false;
    }


    public void addFruit(Fruit f){
        if (f instanceof Apple){
            if(isEmpty()){
                box = new ArrayList<>();
            }
            else{
                if(box.get(0) instanceof Orange)
                    return;
            }
            Apple a = (Apple)f;
            box.add(a);
        }
        else if (f instanceof Orange){
            if(isEmpty()){
                box = new ArrayList<Fruit>();
            }
            else{
                if(box.get(0) instanceof Apple)
                    return;
            }
            ;
            box.add((Orange)f);

        }
    }

    public void moveTo(FruitBox anotherBox){
        if(box.isEmpty()) return;

        if(anotherBox.isEmpty()){

            ArrayList box = anotherBox.getBox();
            box = new ArrayList<Fruit>();
            for(Fruit f : this.box) {

                box.add(f);
            }
            this.box.removeAll(this.box);
            return;
        }
        boolean isOrange = box.get(0) instanceof Orange;
        boolean isAnotherOrange = anotherBox.getBox().get(0) instanceof Orange;

        if((isOrange && isAnotherOrange)  || (!isOrange && !isAnotherOrange)){
            //refill
            ArrayList box = anotherBox.getBox();
            for(Fruit f : this.box){
                box.add(f);
            }
            this.box.removeAll(this.box);

            return;
        }

    }
}
