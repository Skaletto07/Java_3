package lesson_1;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
   private ArrayList<T> box;

    public Box() {
        this.box = new ArrayList<>();
    }

    public Float getWeight() {
        float weight;
        if (box.isEmpty()) {
            return 0f;
        } else {
            weight = 0;
            for (T count : box) {
               weight += count.getCountFruit() * count.getWeight();
            }
            return weight;
        }
    }

    public boolean compare(Box<? extends Fruit> box) {
        return Math.abs(this.getWeight() - box.getWeight()) < 0.0001;
    }

    public void transfer(Box<? super T> b) {
        b.box.addAll(this.box);
        this.box.clear();
    }

    @SafeVarargs
    public final void addFruit(T... t1) {
        box.addAll(Arrays.asList(t1));
    }

    public void content() {
        if (this.box.isEmpty()) {
            System.out.println("В коробке пусто!");
        } else {
            for (T t : this.box) {
                System.out.println(t.getName() + ": " + t.getCountFruit());
            }
        }
    }


}
