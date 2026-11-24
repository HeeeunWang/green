package P04;
public class BreakOutterExample {
    public static void main(String[] args) throws Exception{
        Outter: for(char upper='A'; upper<='Z'; upper++){
                    for(char lower='a'; lower<='z'; lower++){
                        System.out.println(upper+"-"+lower);
                        if(upper=='B' && lower=='g'){
                            break Outter;
                        }
                    }
                }
        System.out.println("종료");
    }

}
