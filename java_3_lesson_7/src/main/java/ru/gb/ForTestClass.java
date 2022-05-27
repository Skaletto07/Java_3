package ru.gb;

import ru.gb.ANNATATIONS.AfterSuite;
import ru.gb.ANNATATIONS.BeforeSuite;
import ru.gb.ANNATATIONS.Test;

import java.lang.reflect.*;


public class ForTestClass
{
    public static void main(String[] args) {

    }
    public static void start(Class testClass) {
        Object instance = null;
        int first = 0;
        int last = 0;
        try {
             instance = testClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Method(s) of the class: " + testClass.getName());
        Method[] declaredMethods = testClass.getDeclaredMethods();

        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (first == 0) {
                    runMethod(method, instance);
                    first++;
                } else throw new RuntimeException("BeforeSuite может быть только 1!");
            }
        }
        for (int i = 1; i <= 10; i++) {
            for (Method declaredMethod : declaredMethods) {
                if (declaredMethod.isAnnotationPresent(Test.class)) {
                    if (declaredMethod.getAnnotation(Test.class).priority() == i) {
                        runMethod(declaredMethod, instance);
                    }
                }
            }
        }

        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(AfterSuite.class)) {
                if (last == 0) {
                    runMethod(method, instance);
                    last++;
                } else throw new RuntimeException("BeforeSuite может быть только 1!");
            }
        }
    }

    public static void runMethod(Method method, Object instance) {

        String returnType = method.getReturnType().getName();
        if ("void".equals(returnType)) {
            int modifiers = method.getModifiers();
            Parameter[] parameters = method.getParameters();
            if (parameters.length > 0) {
                for (Parameter methodParameter : method.getParameters()) {
                    if (methodParameter != null) {
                        String name = methodParameter.getType().getName();
                        if ("java.lang.String".equals(name)) {
                            if (Modifier.isPrivate(modifiers)) {
                                method.setAccessible(true);
                                try {
                                    method.invoke(instance, "Private something");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } else {
                                try {
                                    method.invoke(instance, "Something");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {
                            System.out.println("Только 1 параметр стринг сделал");
                        }
                    }
                }
            } else {
                if (Modifier.isPrivate(modifiers)) {
                    method.setAccessible(true);
                    try {
                        method.invoke(instance);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        method.invoke(instance);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println("Это уже сложнее!");
        }
    }
}
