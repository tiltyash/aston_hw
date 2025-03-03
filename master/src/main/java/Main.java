import javax.sound.midi.Soundbank;
import java.util.Base64;

public class Main {
    public static void main(String[] args) {
        Bowl bowl = new Bowl(50);

        Cat cat = new Cat("Кокос", 15);
        Cat cat1 = new Cat("Шуня", 17);
        Cat cat2 = new Cat("Сильвестр", 20);
        cat.eat(bowl);
        cat1.eat(bowl);
        cat2.eat(bowl);

        System.out.println(cat.name + " поел: " + cat.isFull());
        System.out.println(cat1.name + " поел: " + cat1.isFull());
        System.out.println(cat2.name + " поел: " + cat2.isFull());
        System.out.println("Осталось в миске: " + bowl.getAvailableFood());

        bowl.addFood(2);

        cat2.eat(bowl);

        System.out.println(cat2.name + " поел: " + cat2.isFull());

        Dog dog = new Dog("Боня");
        dog.run(500);
        dog.swim(5);
        dog.run(-10);
        dog.swim(-5);

        cat.run(210);
        cat.swim(20);
        cat.swim(-1000);

        System.out.println("Осталось в миске: " + bowl.getAvailableFood());


    }
}
