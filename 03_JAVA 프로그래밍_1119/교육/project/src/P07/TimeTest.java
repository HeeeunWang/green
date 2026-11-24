package P07;
import ClassZip.Time;
public class TimeTest
 {
    public static void main(String[] args) {
        Time t = new Time(12, 35, 29);
        System.out.println(t);
        t.setHour(t.getHour()+1);
        System.out.println(t);
    }
}




