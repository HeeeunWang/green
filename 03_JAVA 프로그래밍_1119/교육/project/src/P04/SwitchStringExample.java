package P04;
public class SwitchStringExample {
    public static void main(String[] args) {
        String position = "과장";

        switch (position) {
            case "부장":
                System.out.println(position+" 직급: 700만원");
                break;
            case "과장":
                System.out.println(position+" 직급: 500만원");
                break;
            default:
                System.out.println(position+" 직급: 300만원");
                break;
        }
    }
}
