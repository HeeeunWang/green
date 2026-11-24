package P실습01;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class BookManager implements Manageable{
    private List<Book> books = new ArrayList<Book>();
    // private List<Book> books = new Vector<Book>(); // 여러 스레드에서 동시 접속 가능

    // 
    public BookManager(){
        loadFromFile();
    }

    @Override 
    public void addItem(Book book){
        books.add(book);
        System.out.println("등록되었습니다.");        
    }

    @Override 
    public void displayAll(){        
        if(books.size()==0){
            System.out.println("등록된 도서가 없습니다.");
        }else{
            System.out.println("ID \t 제목 \t 저자");
            for(int i=0; i<this.books.size(); i++){
                Book book = this.books.get(i);
                System.out.println(String.format("%d \t %s \t %s", book.getId(), book.getTitle(), book.getAuther()));
            }
        }        
    }

    @Override 
    public void saveToFile(){
        File file = new File("C:\\java_home\\project\\src\\books.txt");
        try {
            // 파일 없으면 생성
            if(file.exists()==false){ file.createNewFile(); }
            // 파일 라이터
            FileWriter writer = new FileWriter(file);
            for(Book book: books){
                String bookSaveStr = book.toFileString();
                writer.write(bookSaveStr);
                writer.flush();
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("저장파일생성실패!");
        }
    }

    @Override
    public void loadFromFile(){
        File file = new File("C:\\java_home\\project\\src\\books.txt");
        if(file.exists()){
            try {
                FileReader reader = new FileReader(file);
                BufferedReader br = new BufferedReader(reader);
                while(true){
                    String line = br.readLine();
                    if (line==null) break;
                    try {
                        Book book = new Book();
                        String[] result = line.split("\t");
                        if(result.length==3){
                            book.setId(Integer.parseInt(result[0]));
                            book.setTitle(result[1]);
                            book.setAuther(result[2]);
                            books.add(book);
                        }                        
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("도서 목록의 입력값 잘못되었습니다: 해당 라인 건너뜀!");
                    }
                }
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("저장파일로드실패!");
            }
        }else{
            System.out.println("저장된 도서 목록이 존재하지 않습니다.");
        }
    }
}
