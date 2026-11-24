package P실습01;
import java.util.Scanner;

public class BookLib {
    public static void main(String[] args) {
        BookManager bookmanager = new BookManager();
        BookUtil.librarySystem();

        try {            
            Scanner scanner = new Scanner(System.in);
            boolean doit = true;
            String inputString;
            do{  
                inputString = scanner.nextLine();
                switch(inputString){
                    case "1":
                        System.out.println("도서 등록을 선택하셨습니다.");
                        System.out.println("[도서 등록]");
                        Book book = BookUtil.setBook(scanner);
                        if(book!=null){
                            bookmanager.addItem(book);
                            System.out.println("결과: 성공적으로 등록되었습니다.");
                        }
                        System.out.print("메뉴 선택> ");
                        break;
                    case "2":
                        System.out.println("도서 목록 조회를 선택하셨습니다.");
                        bookmanager.displayAll();
                        System.out.print("메뉴 선택> ");
                        // 전체 or id 등등으로 검색
                        break;
                    case "3":
                        System.out.println("저장 및 종료를 선택하셨습니다.");
                        bookmanager.saveToFile();
                        doit = false;
                        break;
                    default:
                        System.out.println("잘못 입력하셨습니다.");
                        BookUtil.librarySystem();                        
                        break;
                }
            }while(doit);
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
