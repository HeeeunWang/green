package P06;
import ClassZip.Car3;
public class Car3Example {
    public static void main(String[] args) {
        Car3 myCar = new Car3();

        myCar.setSpeed(-50);
        System.out.println("현재 속도: "+ myCar.getSpeed());
        System.out.println("정지중?: "+ myCar.isStop());
        System.out.println();

        myCar.setSpeed(60);
        System.out.println("현재 속도: "+ myCar.getSpeed());
        System.out.println("정지중?: "+ myCar.isStop());
        System.out.println();

        if(!myCar.isStop()){
            myCar.setStop(true);
        }
        System.out.println("현재 속도: "+ myCar.getSpeed());
        System.out.println("정지중?: "+ myCar.isStop());
        System.out.println();

        myCar.setSpeed(60);
        System.out.println("현재 속도: "+ myCar.getSpeed());
        System.out.println("정지중?: "+ myCar.isStop());
        System.out.println();
    }
}
