package P실습02;
import java.util.Scanner;
public class BookUtil {
    static Book setBook(Scanner scanner){
        Book book = new Book();
        try {
            // ID 입력
            System.out.print("ID>");
            String inputString = scanner.nextLine();
            int inputId = Integer.parseInt(inputString);
            if(inputId>99999){
                System.out.println("ID를 잘못입력하셨습니다.");
                return null;
            }
            book.setId(String.format("%05d", inputId));
            System.out.println("getID: "+book.getId());
            // 제목 입력
            System.out.print("제목>");
            inputString = scanner.nextLine();
            book.setTitle(inputString);
            System.out.println("getTitle: "+book.getTitle());
            // 저자 입력
            System.out.print("저자>");
            inputString = scanner.nextLine();
            book.setAuther(inputString);
            System.out.println("getTitle: "+book.getAuther());
            return book;            
        } catch (Exception e) {
            System.out.println("잘못입력하셨습니다.");
            return null;
        }        
    }
    static void librarySystem(){
        System.out.println();
        System.out.println("==== LIBRARY SYSTEM ====");
        System.out.println("1. 도서 등록");
        System.out.println("2. 도서 목록 조회");
        System.out.println("3. 저장 및 종료");  
        System.out.print("메뉴 선택> ");
    }
}
