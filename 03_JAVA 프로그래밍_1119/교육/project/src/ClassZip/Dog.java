package ClassZip;

public class Dog extends Animal {
    public Dog(){
        this.kind = "포유류";
    }

    @Override 
    // abstract sound()는 반드시 오버라이드 해야함
    public void sound(){
        System.out.println("멍멍");
    }
}
