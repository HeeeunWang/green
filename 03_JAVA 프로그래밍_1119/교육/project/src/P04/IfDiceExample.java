package P04;
public class IfDiceExample {
    public static void main(String[] args) {
        int num = (int)(Math.random()*6) + 1;
    
        if(num == 1){
            System.out.println("1 입니다.");
        }else if(num==2){
            System.out.println("2 입니다.");
        }else if(num==3){
            System.out.println("3 입니다.");
        }else if(num==4){
            System.out.println("4 입니다.");
        }else if(num==5){
            System.out.println("5 입니다.");
        }else if(num==6){
            System.out.println("6 입니다.");
        }else{
            System.out.println("그럴리가없는데?");
        }
    }
}
