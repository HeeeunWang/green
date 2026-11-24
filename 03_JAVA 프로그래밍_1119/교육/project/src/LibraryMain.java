import java.util.Scanner;

public class LibraryMain {
    static void printLogInMenu(){
        System.out.println("==== LIBRARY SYSTEM LOGIN ====");
        System.out.println("1. 로그인");
        System.out.println("2. 신규 회원 가입");
        System.out.println("3. 종료");
        System.out.print("메뉴 선택> ");
    }
    static void printMemberMenu(){
        System.out.println("==== LIBRARY SYSTEM ====");
        System.out.println("1. 도서 대여");
        System.out.println("2. 도서 반납");
        System.out.println("3. 마이페이지");
        System.out.println("4. 개인정보 수정");
        System.out.println("5. 로그 아웃");
        System.out.print("메뉴 선택> "); 
    }
    public static void main(String[] args) {
        Member member;
        
        // 1. 로그인 혹은 신규회원가입
        try {            
            Scanner scanner = new Scanner(System.in);
            boolean doit = true; // 종료 조건에 대한 bool
            String inputString;

            // 종료 조건이 만족될 때 까지 작동
            do{  
                printLogInMenu();
                inputString = scanner.nextLine();
                switch(inputString){
                    case "1":
                        System.out.println();
                        System.out.println("[로그인]");
                        member = MembersDbAcc.logIn(scanner);
                        if(member==null){
                            System.out.println("로그인에 실패하셨습니다.");
                            break;
                        }else{
                            System.out.println(member.getMId()+"님 환영합니다!");
                            printMemberMenu();
                            inputString = scanner.nextLine();
                            break;
                        }
                        
                    case "2":
                        System.out.println("[회원가입]");
                        MembersDbAcc.SignUp(scanner);
                        break;

                    case "3":
                        System.out.println("LIBRARY SYSTEM을 종료합니다.");
                        System.out.println();
                        doit = false;
                        break;

                    default:
                        // 잘못된 번호나 문자 입력 시 예외 처리
                        System.out.println();
                        System.out.println("잘못 입력하셨습니다.");
                        System.out.println();               
                        break;
                }
            }while(doit);
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}
