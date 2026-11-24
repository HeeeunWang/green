package P07;
import ClassZip.*;
public class AnimalExample {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        dog.sound();
        cat.sound();
        System.out.println("------------------");

        Animal animal = null;
        animal = new Dog();
        animal.sound();
        animal = new Cat();
        animal.sound();
        System.out.println("------------------");

        animalSound(new Dog());
        animalSound(new Cat());
    }
    public static void animalSound(Animal animal){
        // 같은 클래스에 구현해도 static이 없으면 객체없이 사용할 수 없으니 주의!
        animal.sound();
    }
}
