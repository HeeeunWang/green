package P04;
import java.io.IOException;

public class WhileKeyComtrolExample {
    public static void main(String[] args) {
        boolean run = true;
        int speed = 0;
        int keyCode = 0;

        while(run){
            if(keyCode!=13 && keyCode!=10){
                System.out.println("---------------------");
                System.out.println("1.증속 | 2.감속 | 3.중지");
                System.out.print("선택: ");
            }

            try {
                keyCode = System.in.read(); //
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            if(keyCode == 49){
                speed++;
                System.out.println("현재 속도= "+speed);
            }else if(keyCode == 50){
                speed--;
                System.out.println("현재 속도= "+speed);
            }else if(keyCode == 51){
                run = false;
            }
        }
        System.out.println("종료");
    }
}
