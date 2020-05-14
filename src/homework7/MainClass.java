package homework7;

import homework7.customJUnit.JUnit;

import java.lang.reflect.InvocationTargetException;

public class MainClass {

    public static void main(String[] args) {
        try {
            JUnit.start(TestLogicalOperations.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
