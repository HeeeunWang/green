package P03;
public class SignOperatorExample {
    public static void main(){
        int x = -100;
        int result1 = +x;
        int result2 = -x;
        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);

        short s = 100;
        // short result3 = -s; < 연산은 int로 넘겨서 하니까 short는 컴파일 에러
        int result3 = -s;
        System.out.println("result3 = " + result3);
    }
}
