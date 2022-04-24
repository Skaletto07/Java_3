package lesson_1;

import lesson_1.fruit.Apple;
import lesson_1.fruit.Orange;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Задание 1 (Проверка)
        Integer[] abc = {1,2,3,4,5,6,7,8,9,0};
        Main mainn = new Main();
        for (Integer integer : abc) {
            System.out.print(integer);
        }
        System.out.println();
        mainn.swap(abc, 2, 7);
        for (Integer integer : abc) {
            System.out.print(integer);
        }
        // Задание 2 (Проверка)
        ArrayList<Integer> transformation = mainn.transformation(abc);
        System.out.println();
        for (Integer integer : transformation) {
            System.out.print(integer);
        }
        System.out.println();

        // Задание 3 (Проверка)
        Apple apple1 = new Apple(100, "Фуджи");
        Apple apple2 = new Apple(5, "Голден");
        Apple apple3 = new Apple(18, "Спартан");
        Orange orange1 = new Orange(64, "Гамлин");
        Orange orange2 = new Orange(32, "Верна");
        Orange orange3 = new Orange(2, "Моро");

        Box<Apple> appleBox = new Box<>();
        appleBox.addFruit(apple1,apple2,apple3);

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(orange1, orange2, orange3);

        System.out.println(appleBox.compare(orangeBox));

        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.getWeight());

        appleBox.content();

        Box<Apple> appleBox1= new Box<>();
        appleBox.transfer(appleBox1);

        appleBox.content();
        appleBox1.content();


    }

    // Задание 1
    public<T> void swap(T[] t, int a, int b) {
        T z;
        z = t[a];
        t[a] = t[b];
        t[b] = z;
    }

    // Задание 2
    public<T> ArrayList<T> transformation(T[] t) {
        return new ArrayList<>(Arrays.asList(t));
    }

}
