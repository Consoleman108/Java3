package homework5;

import homework5.Stages.Road;
import homework5.Stages.Tunnel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static final CountDownLatch START = new CountDownLatch(CARS_COUNT);
    public static final CountDownLatch FINISH = new CountDownLatch(CARS_COUNT);
    public static final Semaphore SEMAPHORE_TUNNEL = new Semaphore((int) CARS_COUNT/2);
    public static final CountDownLatch WIN = new CountDownLatch(1);
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        for(int i = 0; i < CARS_COUNT; i++){
            cars.add(new Car(
                            new Race(
                                    new Road(60),
                                    new Tunnel(),
                                    new Road(40)),
                    20 + (int) (Math.random() * 10)) );
        }

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        for(Car item: cars) {
            new Thread(item).start();
        }

        try {
            START.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        try {
            FINISH.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}