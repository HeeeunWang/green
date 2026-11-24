package P05;
public class EnumMethodExample {
    public enum Week{
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }
    public static void main(String[] args) {
        //name() 메소드
        System.out.println("-- name() method : 열거 객체의 문자열을 리턴");
        Week today = Week.SUNDAY;
        String name = today.name();
        System.out.println(name);

        System.out.println("-- ordinal() method : 열거 객체의 순번(0부터)을 리턴");
        //ordinal() 메소드
        int ordinal = today.ordinal();
        System.out.println(ordinal);

        System.out.println("-- compareTo() method : 열거 객체를 비교해서 순번 차이를 리턴");
        //compareTo() 메소드
        Week day1 = Week.MONDAY;
        Week day2 = Week.WEDNESDAY;
        int result1 = day1.compareTo(day2);
        int result2 = day2.compareTo(day1);
        System.out.println(result1);
        System.out.println(result2);

        System.out.println("-- valueOf() method : 주어진 문자열을");
        //valueOf() 메소드
        // Week weedDay = Week.valueOf("SUNDAY");
    }
}   
