package P05;
import java.util.Calendar;

public class EnumWeek {
    public enum Week{
        MONDAY,
        TUESDAY,
        수요일,
        목요일,
        FRIDAY,
        토요일,
        일요일
    }

    public static void main(){
        Week today = null;

        Calendar cal = Calendar.getInstance();
        int week = cal.get(Calendar.DAY_OF_WEEK);

        switch (week) {
            case 1: today = Week.일요일; break;
            case 2: today = Week.MONDAY; break;
            case 3: today = Week.TUESDAY; break;
            case 4: today = Week.수요일; break;
            case 5: today = Week.목요일; break;
            case 6: today = Week.FRIDAY; break;
            case 7: today = Week.토요일; break;
        }

        System.out.println("오늘은? "+ today);
        if(today!= Week.일요일){
            System.out.println("공부하세요");
        }else{
            System.out.println("놀까?");
        }
    }
}
