package P03;
public class InfinityAndNaNCheckExample {
    public static void main(String[] args) {
        int x = 5;
        double y = 0.0;

        double z = x / y;
        
        System.out.println(Double.isInfinite(z));
        System.out.println(Double.isNaN(z));

        if(Double.isInfinite(z)||Double.isNaN(z)){
            System.out.println("잘못입력하셨븐디ㅏ");
        }else{
            System.out.println(z+2);
        }
    }
}
