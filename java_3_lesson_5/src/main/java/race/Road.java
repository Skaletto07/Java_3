package race;

import java.util.concurrent.CountDownLatch;

public class Road extends Stage {
    private CountDownLatch finish = new CountDownLatch(4);
    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }
    public Road(int length, CountDownLatch finish) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
        this.finish = finish;
    }


    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);
            Car.f.add(c.getName());
            finish.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                finish.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
