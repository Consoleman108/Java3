package homework7.customJUnit;

import homework7.classForTest.ClassForTest;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class JUnit {

    public static void start(Class inputClass) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object testClassObject = inputClass.newInstance();
        Method[] methods = inputClass.getDeclaredMethods();
        Class clazz = ClassForTest.class;
        Method beforeMethod = null;
        Method afterMethod = null;
        List<Method> testeMethod = new ArrayList<>();

        int countAnnotationBeforeSuite = -1;
        int countAnnotationAfterSuite = -1;
        int countAnnotationTets = -1;

        for (Method method : methods) {
            if(method.isAnnotationPresent(BeforeSuite.class)) {
                countAnnotationBeforeSuite++;
                beforeMethod = method;
            }
            if(method.isAnnotationPresent(AfterSuite.class)){
                countAnnotationAfterSuite++;
                afterMethod = method;
            }
            if(method.isAnnotationPresent(Test.class)){
                countAnnotationTets++;
                testeMethod.add(method);
            }
        }

        if(countAnnotationBeforeSuite >= 1) {
            throw new RuntimeException("To many annotation BeforeSuite");
        } else {
            beforeMethod.invoke(testClassObject);
            System.out.println("");
        }

        if(countAnnotationTets  == -1) {
            throw new RuntimeException("Missing annotations Test");
        } else {
            testeMethod.stream().sorted(Comparator.comparingInt(method -> method.getAnnotation(Test.class).priority())).collect(Collectors.toList());
            for (Method method : testeMethod) {
                System.out.println("Anntation priority: " + method.getAnnotation(Test.class).priority());

                System.out.print("Method: ");
                System.out.println(method.getReturnType() + " "
                                 + method.getName() + "( "
                                 + Arrays.toString(method.getParameterTypes()) + " ) ");
                method.invoke(testClassObject);
                System.out.println("\n");
            }
        }

        if(countAnnotationAfterSuite >= 1) {
            throw new RuntimeException("To many annotation AfterSuite");
        } else {
            afterMethod.invoke(testClassObject);
        }

    }

    public static void IsTrue(boolean inputData){
        if (inputData){
            System.out.print("Test Passed");
        }else {
            System.out.print("Test Failed");
        }
    }

    public static void IsFalse(boolean inputData){
        if (!inputData){
            System.out.print("Test Passed");
        }else {
            System.out.print("Test Failed");
        }
    }
}
