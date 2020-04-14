package homework1;

import homework1.fruits.Apple;
import homework1.fruits.Box;
import homework1.fruits.Orange;

public class MainFruit {
    public static void main(String[] args) {
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();
        Orange orange4 = new Orange();

        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox1 = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();

        appleBox.addFruitInBox(apple1);
        appleBox.addFruitInBox(apple2);
        appleBox.addFruitInBox(apple3);

        orangeBox1.addFruitInBox(orange1);
        orangeBox1.addFruitInBox(orange2);
        orangeBox1.addFruitInBox(orange3);
        orangeBox1.addFruitInBox(orange4);

        orangeBox1.emptyBox(orangeBox2);

        System.out.println("Apple Box weight: " + appleBox.getWeight());
        System.out.println("Orange Box1 weight: " + orangeBox1.getWeight());
        System.out.println("Orange Box2 weight: " + orangeBox2.getWeight());
        System.out.println("Compare Orange Box1 and Box2: " + appleBox.compare(orangeBox1));
    }
}
