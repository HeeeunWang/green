package P04;
import java.util.Scanner;
public class CalculateTotalScoreAndAvg {
    public static void main(String[] args) {
        boolean run = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("총점과 평균을 계산하는 프로그램!");
        System.out.println("계산는 calc or Enter");

        int count = 0;
        double total = 0;
        while (run) {
            System.out.print("점수를 입력하시오: ");
            String strNum = scanner.nextLine();
            if(strNum.equals("calc")||strNum.equals("")){
                run = false;
            }else{
                try {
                    Double num = Double.parseDouble(strNum);
                    if(num < 0 || num > 100){
                        System.out.println("잘못입력하셨습니다. 점수는 0~ 100사이입니다.");
                        continue;
                    }
                    count++;
                    total+=num;  
                } catch (Exception e) {
                    System.out.println("잘못입력하셨습니다.");
                    continue;
                }             
            }            
        }
        System.out.println(String.format("총 %d인", count));
        System.out.println("총점: "+ total);
        System.out.println("평균: "+ total/count);
        scanner.close();
    }    
}
