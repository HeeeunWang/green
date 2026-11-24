package P01_02;
public class VariableScopeExample {
    public static void main(String[] args){
        int v1 = 15; // 정수 리터럴
        int v3; // 초기값(입력값)이 없는 상태로는 사용못함
        if(v1>10){
            int v2;
            v2= v1-10;
            v3 = v1 + v2 + 5;
            System.out.println(v3); 
        }
        // System.out.println(v3); //< if가 실행되지 않을 수 있으면 오류
    }
}
