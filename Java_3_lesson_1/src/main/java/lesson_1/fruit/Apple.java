package lesson_1.fruit;

import lesson_1.Fruit;

public class Apple extends Fruit {

    public Apple(int countFruit) {
        super(countFruit);
    }

    public Apple(int countFruit, String name) {
        super(countFruit, name);
    }

    @Override
    public float getWeight() {
        return 1f;
    }
}
