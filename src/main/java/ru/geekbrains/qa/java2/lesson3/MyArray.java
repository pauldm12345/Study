package ru.geekbrains.qa.java2.lesson3;

public class MyArray <T> {
    private T[] nums;

    public MyArray(T... nums) {
        this.nums = nums;
    }

    public T[] getArray(){
        T[] nums = this.nums;
        return nums;
    }

    public boolean exchange(int i, int j) {
        if(i != j && (i >=0 && i < nums.length) && (j >=0 && j < nums.length)){
            T object = nums[i];
            nums[i] = nums[j];
            nums[j] = object;
            return true;
        }

        return false;
    }

}
