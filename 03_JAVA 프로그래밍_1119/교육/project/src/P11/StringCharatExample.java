package P11;
public class StringCharatExample {
    public static void main(String[] args) {
        String ssn = "010564-1534864";
        char sex = ssn.charAt(7);
        switch (sex){
            case '1':
            case '3':
                System.out.println("뽀이입니다.");
                break;
            case '2':
            case '4':
                System.out.println("걸입니다.");
                break;
        }
    }
}
