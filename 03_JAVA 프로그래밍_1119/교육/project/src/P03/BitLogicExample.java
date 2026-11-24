package P03;
public class BitLogicExample {
    public static void main(String[] args) {
        System.out.println("45 & 25 = " + (45 & 25));
        System.out.println("45 | 25 = " + (45 | 25));
        System.out.println("45 ^ 25 = " + (45 ^ 25));
        System.out.println("~45 = " + (~45));

        byte receiveData = -120;

        int unsignedInt1 = receiveData & 255;
        System.out.println(unsignedInt1);
    }
}
