package homework5;

import static homework5.MainClass.*;

public class Car implements Runnable {
    private static int CARS_COUNT = 0;
    private Race race;
    private int speed;
    private String name;

    public Car(Race race, int speed) {
        this.race = race;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.speed = speed;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            START.countDown();
            System.out.println(this.name + " готов");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            START.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

//        WIN.countDown();
//        if (WIN.getCount() == 0) {
//            System.out.println("Победитель " + getName());
//        }
        FINISH.countDown();

    }

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
}
