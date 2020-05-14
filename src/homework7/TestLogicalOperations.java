package homework7;

import homework7.classForTest.ClassForTest;
import homework7.customJUnit.AfterSuite;
import homework7.customJUnit.BeforeSuite;
import homework7.customJUnit.JUnit;
import homework7.customJUnit.Test;

public class TestLogicalOperations {

    private static ClassForTest classForTest;

    @BeforeSuite
    public void init(){
        classForTest = new ClassForTest();
        System.out.println("Init");
    }

    @Test(priority = 1)
    public void test_not_true() {
        JUnit.IsTrue(classForTest.not(false));
    }

    @Test(priority = 2)
    public void test_not_false() {
        JUnit.IsFalse(classForTest.not(true));
    }

    @Test(priority = 3)
    public void test_and_true() {
        JUnit.IsTrue(classForTest.and(true, true));
    }

    @Test(priority = 4)
    public void test_and_false() {
        JUnit.IsFalse(classForTest.and(true, false));
    }

    @Test
    public void test_or_true() {
        JUnit.IsTrue(classForTest.or(true, false));
    }

    @Test
    public void test_or_false() {
        JUnit.IsFalse(classForTest.or(false, false));
    }

    @Test(priority = 6)
    public void test_xor_true() {
        JUnit.IsTrue(classForTest.xor(true, false));
    }

    @Test(priority = 6)
    public void test_xor_false() {
        JUnit.IsFalse(classForTest.xor(true, true));
    }

    @Test(priority = 7)
    public void test_and_not_pass() {
        JUnit.IsFalse(classForTest.and(true, true));
    }

    @AfterSuite
    public void after(){
        classForTest = null;
        System.out.println("Reset");
    }
}
