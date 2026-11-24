package ClassZip;

public class Cat extends Animal {
    public Cat(){
        this.kind = "포유류";
    }

    @Override 
    // abstract sound()는 반드시 오버라이드 해야함
    public void sound(){
        System.out.println("야옹");
    }
}
