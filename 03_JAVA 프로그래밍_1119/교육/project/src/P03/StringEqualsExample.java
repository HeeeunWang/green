package P03;
public class StringEqualsExample {
    public static void main(String[] args) {
        String strVar1 = "신민철"; // 주소 0x00 저장
        String strVar2 = "신민철"; // 주소 0x00 저장 < string pool에서 사용하기에 같은 주소
        String strVar3 = new String("신민철"); // 주소 0x40 저장 < new!로 새로 생성 -> 다른 주소를 가짐

        System.out.println(strVar1 == strVar2); // 0x00 == 0x00 :?
        System.out.println(strVar1 == strVar3); // 0x00 == 0x40 :?
        System.out.println();
        
        // 주소 말고 내용을 비교하고 싶으면 equals 사용
        System.out.println(strVar1.equals(strVar2)); // "신민철" == "신민철" :?
        System.out.println(strVar1.equals(strVar3)); // "신민철" == "신민철" :?
    }
}
