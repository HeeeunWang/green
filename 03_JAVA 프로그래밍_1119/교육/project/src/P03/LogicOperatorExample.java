package P03;
public class LogicOperatorExample {
    public static void main(String[] args) {
        int charCode = 's';

        if((charCode>=65)&&(charCode<=90)){
            System.out.println("대문자요");
        }

        if((charCode>=97)&(charCode<=122)){
            System.out.println("소문자요");
        }

        if(!(charCode<48)&&!(charCode>57)){
            System.out.println("0~9의 숫자요");
        }

        int value = 4;
        if((value%2==0)|(value%3==0)){
            System.out.println("6의 배수요");
        } 
        // > 비트논리합
        // 두 경우 모두 연산해보고 결과를 도출

        if((value%2==0)||(value%3==0)){
            System.out.println("2 또는 3의 배수요");
        }
        // > 논리합
        // 첫번째 조건이 맞으면 두번째 조건은 연산 하지 않고 true 반환
        // 첫번재 조건이 틀리면 두번째 조건을 연산 후 결과 도출
    }
}
