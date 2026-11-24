package P07;
import ClassZip.*;
public class PhoneExample {
    public static void main(String[] args) {
        // Phone phone = new Phone("홍길동");
        SmartPhone smPhone = new SmartPhone("홍길동");
        smPhone.turnOn();
        smPhone.internetSearch();
        smPhone.turnOff();
    }
}
