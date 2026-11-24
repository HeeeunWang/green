package P18;
import java.io.Console;

public class ConsoleExample {
    public static void main(String[] args) {
        Console console = System.console();

        System.out.print("아이디: ");
        String id = console.readLine();

        System.out.print("패스워드");
        char[] charPw = console.readPassword();
        String strPw = new String(charPw);

        System.out.println("--------------------------");
        System.out.println(id);
        System.out.println(strPw);
    }
}
