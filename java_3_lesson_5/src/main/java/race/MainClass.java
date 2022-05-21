package race;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;


public class MainClass {
    public static final int CARS_COUNT = 4;
    private final CountDownLatch start = new CountDownLatch(CARS_COUNT);
    private final CountDownLatch finish = new CountDownLatch(CARS_COUNT);
    private final Semaphore semaphore = new Semaphore(CARS_COUNT / 2);

    public static void main(String[] args) {

        MainClass mc = new MainClass();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(mc.semaphore), new Road(40, mc.finish));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), mc.start);
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        while (mc.start.getCount() > 0) {}
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        while (mc.finish.getCount() > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        System.out.println("Победитель: " + Car.f.get(4) + " !!!");

    }


}
