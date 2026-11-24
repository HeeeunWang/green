package P07;
import ClassZip.SupersonicAirplane;

public class SupersonicAirplaneExample {
    public static void main(String[] args) {
        System.out.println("static NORMAL= "+ SupersonicAirplane.NORMAL);
        System.out.println("static SUPERSONIC= "+ SupersonicAirplane.SUPERSONIC);
        
        SupersonicAirplane sa = new SupersonicAirplane();
        sa.takeOff();
        sa.fly();
        sa.flyMode= SupersonicAirplane.SUPERSONIC;
        sa.fly();
        sa.flyMode= SupersonicAirplane.NORMAL;
        sa.fly();
        sa.land();
    }
}
