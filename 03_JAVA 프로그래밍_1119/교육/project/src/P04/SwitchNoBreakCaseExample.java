package P04;
public class SwitchNoBreakCaseExample {
    public static void main(String[] args) {
        int time = (int)(Math.random()*4)+8;
        System.out.println("[현재시간: "+time+"시]");

        switch(time){
            // break가 없으면 걸리는 case부터 뒤의 것들이 전부 실행
            case 8:
                System.out.println("출근을해요");
            case 9:
                System.out.println("회의를해요");
            case 10:
                System.out.println("업무를봐요");
            default:
                System.out.println("외근을가요");
        }
    }
}
