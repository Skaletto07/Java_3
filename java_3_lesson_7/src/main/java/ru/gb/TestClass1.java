package ru.gb;

import ru.gb.ANNATATIONS.AfterSuite;
import ru.gb.ANNATATIONS.BeforeSuite;
import ru.gb.ANNATATIONS.Test;


public class TestClass1 {

    @Test(priority = 5)
    public void methodTest1() {
        System.out.println("methodTest1");
    }
    @Test(priority = 1)
    public void methodTest2() {
        System.out.println("text");
    }

    @Test(priority = 2)
    private void methodTest3() {
        System.out.print("methodTest3: ");
        int i = 4;
        int areaSqr = i * i;
        System.out.println(areaSqr);
    }

    @Test(priority = 10)
    public void methodTest4(String s) {
        System.out.println(s);
    }

    @BeforeSuite
    private void beforeSuiteTest() {
        System.out.println("we called the method beforeSuiteTest()");
    }

    @AfterSuite
    public void afterSuiteTest() {
        System.out.println("we called the method afterSuiteTest()");
    }
}
