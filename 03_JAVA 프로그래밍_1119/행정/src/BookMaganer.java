import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class BookMaganer implements Manageable{
    // 도서 목록: 도서 객체를 LIST로 관리
    private List<Book> books = new ArrayList<Book>();
    // 도서 목록 txt 파일의 경로
    private String fileBooksRoot = new StringBuilder()
        .append("./src/books.txt").toString();

    // 생성자: bookmanager 
    public BookMaganer(){
        // loadFromFile(); // -> main에서 호출할것이라 생략
    }
    // 도서 목록 txt를 받아올 수 있는 생성자
    public BookMaganer(String fileBooksRoot){
        // loadFromFile(); // -> main에서 호출할것이라 생략
        this.fileBooksRoot = fileBooksRoot;
    }    
    
    // 데이터 추가
    @Override 
    public void addItem(Book book){
        this.books.add(book);
        System.out.println();
        System.out.println("결과: 성공적으로 등록되었습니다."); 
        System.out.println(" - 등록된 도서 정보");
        System.out.println(" - ID   : "+book.getId());
        System.out.println(" - Title: "+book.getTitle());
        System.out.println(" - Author: "+book.getAuthor());            
    }   

    // 전체 목록 출력
    @Override 
    public void displayAll(){
        // 도서 목록의 모든 도서 객체 정보를 콘솔에 출력
        if(this.books.size()==0){
            // 등록된 도서가 없는 경우
            System.out.println("등록된 도서가 없습니다.");
        }else{
            System.out.println("| ---------------------------------");
            System.out.println("| ID \t 제목 \t\t 저자 \t ");
            System.out.println("| ---------------------------------");
            for(int i=0; i<this.books.size(); i++){
                Book book = this.books.get(i);
                System.out.println(String.format("| %d \t %s \t %s \t ", book.getId(), book.getTitle(), book.getAuthor()));
            }
            System.out.println("| ---------------------------------");
        }
    }   

    // 파일로 데이터 저장
    @Override 
    public void saveToFile(){
        File file = new File(fileBooksRoot);
        try {
            // 파일 없으면 생성
            if(file.exists()==false){ file.createNewFile(); }
            // 파일 라이터
            FileWriter writer = new FileWriter(file); // 덮어쓰기!
            for(Book book: books){
                String bookSaveStr = book.toFileString();
                writer.write(bookSaveStr);
                writer.flush();
            }
            writer.close();
            System.out.println("도서 목록 파일을 저장하였습니다: "+ fileBooksRoot);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("도서 목록 파일 저장에 실패하였습니다.");
        }
    }   

    // 파일에서 데이터 로드
    @Override 
    public void loadFromFile(){
        // java.io로 txt의 도서목록을 읽어와 book객체로 변환 및 도서 목록에 추가
        // 도서 목록 txt 로드
        File file = new File(fileBooksRoot);
        // 파일이 존재하면 로드 존재하지 않으면 loadFromFile 종료 + 예외처리
        if(file.exists()){
            System.out.println("저장된 도서 목록을 불러옵니다: "+ fileBooksRoot);
            try {
                FileReader reader = new FileReader(file);
                BufferedReader br = new BufferedReader(reader);
                while(true){
                    // 버퍼에서 라인 단위로 txt 읽어오기
                    String line = br.readLine();
                    // 더 불러올 라인이 없으면 while문 break
                    if(line==null) break;
                    try {
                        // 라인의 데이터를 저장할 도서 객체
                        Book book = new Book();
                        // book 객체에서 toFileString을 ","로 하기에 동일 적용
                        String[] result = line.split(",");
                        // 라인 데이터 길이 검증
                        if(result.length==3){
                            // String형으로 읽어온 값을 도서 객체에 저장
                            book.setId(Integer.parseInt(result[0])); // int 파싱 필요
                            book.setTitle(result[1]);
                            book.setAuthor(result[2]);
                            // 도서 객체를 도서 목록에 add
                            this.books.add(book);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("도서 목록의 입력값 잘못되었습니다: 해당 라인 제외");
                    }
                }
                // 버퍼 및 파일리더 종료
                br.close();
                reader.close();
                System.out.println("도서 목록 생성을 완료하였습니다.");
                System.out.println("LIBRARY SYSTEM을 실행합니다.");
                System.out.println();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            // 저장된 도서가 없는 경우 안내문구 출력
            System.out.println("저장된 도서 목록이 없습니다: not Found "+ fileBooksRoot);
            System.out.println("LIBRARY SYSTEM을 실행합니다.");
            System.out.println();
        }        
    }   
}
