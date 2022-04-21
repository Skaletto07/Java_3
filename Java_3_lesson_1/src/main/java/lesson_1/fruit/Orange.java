package lesson_1.fruit;

import lesson_1.Fruit;

public class Orange extends Fruit {

    public Orange(int countFruit) {
        super(countFruit);
    }

    public Orange(int countFruit, String name) {
        super(countFruit, name);
    }

    @Override
    public float getWeight() {
        return 1.5f;
    }

}
