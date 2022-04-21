package lesson_1;

 abstract public class Fruit {
     private int countFruit;
     private float weight;
     private String name;

     public Fruit(int countFruit) {
         this.countFruit = countFruit;
     }

     public Fruit(int countFruit, String name) {
         this.countFruit = countFruit;
         this.name = name;
     }

     public int getCountFruit() {
         return countFruit;
     }

     public String getName() {
         return name;
     }

     public abstract float getWeight();
 }
