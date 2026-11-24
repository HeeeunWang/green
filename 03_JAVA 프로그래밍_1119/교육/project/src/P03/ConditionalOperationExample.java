package P03;
import java.util.Scanner;
public class ConditionalOperationExample {
    public static void main(String[] args) {
        // int score = 75;

        Scanner scanner = new Scanner(System.in);
        System.out.println("점수를 입력하세용");
        String strScore = scanner.nextLine();
        int score = Integer.parseInt(strScore);

        char grade = (score>=90)? 'A' : ((score>=80)? 'B' : 'C');
        System.out.println(score+"점은 "+ grade+"등급입니다");

        char grade2;
        if(score >= 90){
            grade2 = 'A';
        }else if(score >= 80){
            grade2 = 'B';
        }else{
            grade2 = 'C';
        }
        System.out.println("Grade2: "+ grade2);
        scanner.close();
    }
}
