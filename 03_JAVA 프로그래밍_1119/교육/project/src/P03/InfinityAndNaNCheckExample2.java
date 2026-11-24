package P03;
import java.util.*;

public class InfinityAndNaNCheckExample2 {    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x;
        double y;

        while(true){
            try {
                System.out.println("정수를 입력하시오");
                String strX = scanner.nextLine();
                System.out.println("실수를 입력하시오");
                String strY = scanner.nextLine();

                x = Integer.parseInt(strX);
                y = Double.parseDouble(strY);
                double z = safediv(x, y);
                System.out.println(z);
                break;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        System.out.println("종료합니다");
        scanner.close();
    }
    // double, float는 0으로 나눠도 오류가 나지않고 infinity, NaN(0/0의 경우)이 반환됨
    // -> 별도의 예외처리 필요
    private static Double safediv(int x, double y){
        if(y == 0.0){
            throw new ArithmeticException("0.0으로 나눌 수 없습니다.");
        }else{
            double z = x / y;  
            return z;
        }
    }
}
