package P01_02;
public class VariableUseExample {
    public static void main(String[] args){
        int hour = 3; // 리터럴!
        int minute = 5; // 리터럴!
        System.out.println(hour+"시간"+minute+"분");

        int totalMinute = (hour)*60+ minute; // 리터럴!
        System.out.println("총 "+totalMinute+"분");
    }
}
