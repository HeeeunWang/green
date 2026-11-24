package P01_02;
import java.util.*;
public class ScannerExample2 {
    public static void main(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("**사칙연산 계산기**");
        System.out.println("첫번째 값 입력: ");
        String strX = scanner.nextLine();
        int x = Integer.parseInt(strX);

        System.out.println("두번째 값 입력: ");
        String strY = scanner.nextLine();
        int y = Integer.parseInt(strY);

        System.out.println("연산 종류 입력: ");
        String how = scanner.nextLine();
        
        if (how.equals("+")|| how.equals("더하기")) {
            System.out.println("x + y = " + (x + y));
        }else if (how.equals("-")|| how.equals("빼기")) {
            System.out.println("x - y = " + (x - y));
        }else if (how.equals("*")|| how.equals("곱하기")) {
            System.out.println("x * y = " + (x * y));
        }else if (how.equals("/")|| how.equals("나누기")) {
            System.out.println("x / y = " + (x / y));
        }else{
            System.out.println("잘못입력하셨습니다.");
        }
        scanner.close();
    }
}
