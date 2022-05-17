package race;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private final Race race;
    private final int speed;
    private final String name;
    private final CountDownLatch cdl;
   static CopyOnWriteArrayList<String> f = new CopyOnWriteArrayList<>();
   static List<String> list = Collections.synchronizedList(new LinkedList<>());

    public Car(Race race, int speed, CountDownLatch cdl) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT ++;
        this.name = "Участник #" + CARS_COUNT;
        this.cdl = cdl;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            cdl.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }


    }

}
