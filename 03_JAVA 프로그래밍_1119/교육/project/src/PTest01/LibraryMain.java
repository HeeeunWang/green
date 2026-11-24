package PTest01;
import java.util.Scanner;

public class LibraryMain {
    public static void main(String[] args) {
        // bookmanager 객체 생성
        BookMaganer bookmanager = new BookMaganer();

        // loadFromFile()호출해서 기존 데이터 불러오기
        bookmanager.loadFromFile();

        try {            
            Scanner scanner = new Scanner(System.in);
            boolean doit = true; // 종료 조건에 대한 bool
            String inputString;

            System.out.println("==== LIBRARY SYSTEM ====");
            System.out.println("1. 도서 등록");
            System.out.println("2. 도서 목록 조회");
            System.out.println("3. 저장 및 종료");  

            // 종료 조건이 만족될 때 까지 작동
            do{  
                System.out.println();
                System.out.print("메뉴 선택> ");
                inputString = scanner.nextLine();
                switch(inputString){
                    case "1":
                        System.out.println();
                        System.out.println("도서 등록을 선택하셨습니다.");
                        System.out.println("[도서 등록]");
                        Book book = setBook(scanner);
                        if(book!=null){
                            bookmanager.addItem(book);                            
                        }
                        break;
                    case "2":
                        System.out.println();
                        System.out.println("도서 목록 조회를 선택하셨습니다.");
                        System.out.println();
                        bookmanager.displayAll();
                        break;
                    case "3":
                        System.out.println();
                        bookmanager.saveToFile();
                        System.out.println("LIBRARY SYSTEM을 종료합니다.");
                        System.out.println();
                        doit = false;
                        break;
                    default:
                        // 잘못된 번호나 문자 입력 시 예외 처리
                        System.out.println();
                        System.out.println("잘못 입력하셨습니다.");
                        System.out.println();
                        System.out.println("==== LIBRARY SYSTEM ====");
                        System.out.println("1. 도서 등록");
                        System.out.println("2. 도서 목록 조회");
                        System.out.println("3. 저장 및 종료");                  
                        break;
                }
            }while(doit);
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static Book setBook(Scanner scanner){
        Book book = new Book();
        try {
            // ID 입력
            System.out.print("ID> ");
            String inputString = scanner.nextLine();
            book.setId(Integer.parseInt(inputString));
            
            // 제목 입력
            System.out.print("제목> ");
            inputString = scanner.nextLine();
            if(inputString==""|inputString==null) {
                System.out.println("잘못 입력하셨습니다.");
                return null;
            }
            book.setTitle(inputString);
            
            // 저자 입력
            System.out.print("저자> ");
            inputString = scanner.nextLine();
            if(inputString==""|inputString==null) {
                System.out.println("잘못 입력하셨습니다.");
                return null;
            }
            book.setAuthor(inputString);            

            // 도서 객체 return
            return book;            
        } catch (Exception e) {
            System.out.println("잘못 입력하셨습니다.");
            return null;
        }        
    }
}
