package P04;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;
public class DoWhileExample {
    public static void main(String[] args) {
        System.out.println("메세지를 입력하세요");
        System.out.println("종료는 q");

        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String inputString;

        do{
            System.out.print(">");
            inputString = scanner.nextLine();
            System.out.println(inputString);
        }while(!inputString.equals("q"));

        System.out.println();
        System.out.println("종료");
        scanner.close();
    }    
}
