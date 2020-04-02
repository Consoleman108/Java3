package homework1.fruits;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit>{
    List<T> arraList = new ArrayList<>();

    public double getWeight() {
        double weightBox = 0;
        for (T item:arraList){
            weightBox += item.weightFruit;
        }
        return weightBox;
    }

    public boolean compare(Box box) {
        boolean result = false;
        if (this.getWeight() == box.getWeight()) {
            result = true;
        }
        return result;
    }

    public void addFruitInBox(T fruitName) {
        arraList.add(fruitName);
    }

    public void emptyBox(Box<T> box)
    {
        for (T item: this.arraList) {
            box.addFruitInBox(item);
        }
        this.arraList.clear();
    }
}
