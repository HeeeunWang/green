package P08;
public class RemoteControlExample {
    public static void main(String[] args) {
        RemoteControl.changeBattery();

        RemoteControl rc;        
        rc = new Television();
        rc.turnOn();
        rc.setVolume(48);
        rc.turnOff();
        rc = new Audio();
        rc.turnOn();
        rc.setVolume(-8);
        rc.turnOff();
        System.out.println("---------------------");

        // RemoteControl rc2 = new RemoteControl(); // 에러!
        RemoteControl rc2 = new RemoteControl() {
            public void turnOn(){System.out.println("익명 객체의 전원을 켭니다.");}
            public void turnOff(){}
            public void setVolume(int volume){}
        };
        rc2.turnOn();
        System.out.println("---------------------");
        
        SmartTelevision rc3 = new SmartTelevision();
        rc = new SmartTelevision();
        rc.turnOn();
        rc.setVolume(7);
        rc3.search("www.naver.com"); 
        // search는 rc에서 쓸 수 없음. remotecontrol interface에는 search가 없어서
        rc.turnOff();
    }
}
