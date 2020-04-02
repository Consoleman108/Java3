package homework1.array;

import java.util.ArrayList;
import java.util.List;

public class ArrayToArrayList<T> {
    private List<T> list = new ArrayList<>();
    private T[] array;

    public ArrayToArrayList(T[] array) {
        this.array = array;
    }

    public List<T> getList() {
        for(T item:array) {
            list.add(item);
        }
        return list;
    }
}
