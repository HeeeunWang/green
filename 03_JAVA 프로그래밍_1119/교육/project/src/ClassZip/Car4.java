package ClassZip;

public class Car4 {
    public int speed;
    public void speedUp(){
        speed++;
    }
    public final void stop(){
        System.out.println("멈춰멈춰!");
        speed=0;
    }
}
