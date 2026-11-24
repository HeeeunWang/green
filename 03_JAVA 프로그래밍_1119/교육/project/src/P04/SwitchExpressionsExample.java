package P04;
public class SwitchExpressionsExample {
    public static void main(String[] args) {
        char grade = 'a';

        switch(grade){
            case 'A', 'a' -> {
                System.out.println("우수회원입니다.");
            }
            case 'b', 'B' -> System.out.println("일반회원입니다.");
            default -> System.out.println("손님입니다.");
        }
    }
}
