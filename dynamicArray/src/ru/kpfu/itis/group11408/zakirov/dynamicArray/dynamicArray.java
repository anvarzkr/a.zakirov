package ru.kpfu.itis.group11408.zakirov.dynamicArray;

import java.util.Objects;

/**
 * Created by Anvar on 10.03.2015.
 */
public class DynamicArray {
    private Object[] objects = new Object[10];
    private int size = 0;

    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addElement(new String("Anvar"));
        dynamicArray.addElement(new String("Anvar"));
        dynamicArray.addElement(new String("Anvar"));
        dynamicArray.addElement(new String("Anvar"));
        dynamicArray.addElement(new String("Anvar"));
        dynamicArray.addElement(new String("Anvar"));
        dynamicArray.addElement(new String("Anvar"));
        dynamicArray.addElement(new String("Anvar"));
        System.out.println(dynamicArray.getSize());
        dynamicArray.addElement(new String("Anvar"));
        dynamicArray.addElement(new String("Anvar"));
        System.out.println(dynamicArray.getElement(2));
        System.out.println(dynamicArray.getSize());
        dynamicArray.addElement(new String("Anvar"));
        dynamicArray.addElement(new String("Anvar"));
        dynamicArray.addElement(new String("Anvar"));
        dynamicArray.addElement(new String("Anvar"));
        dynamicArray.addElement(new String("Anvar"));
        dynamicArray.addElement(new String("Anvar"));
        dynamicArray.addElement(new String("Anvar"));
        dynamicArray.addElement(new String("Anvar"));
        System.out.println(dynamicArray.getSize());
        dynamicArray.addElement(new String("Anvar"));
        dynamicArray.addElement(new String("Anvar"));
        dynamicArray.addElement(new String("Anvar"));
        System.out.println(dynamicArray.getSize());
        dynamicArray.removeElement(1);
    }

    public void addElement(Object obj){
        if (this.size == objects.length){
            Object[] objects_temp = new Object[objects.length + 5];

            for (int i = 0; i < objects.length; i++)
                objects_temp[i] = objects[i];

            this.objects = objects_temp;

        }

        objects[size++] = obj;
    }

    public void insertElement(Object obj, int index){
        if (index < 0 || index >= objects.length)
            throw new IndexOutOfBoundsException();
        objects[index] = obj;
    }

    public void removeElement(int index){
        if (index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException();
        Object[] objects_temp;
        if (this.size - 1 % 5 == 0)
            objects_temp = new Objects[objects.length - 5];
        else
            objects_temp = new Objects[objects.length];

        for (int i = 0, k = 0; i < objects.length; i++, k++){
            if (i == index)
                i++;
            objects_temp[k] = objects[i];
        }
    }

    public Object getElement(int index){
        if (index < 0 || index >= objects.length)
            throw new IndexOutOfBoundsException("");
        return objects[index];
    }

    public int getSize(){
        return this.size;
    }
}
