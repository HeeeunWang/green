package P실습02;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BookManager implements Manageable{
    // private List<Book> books = new ArrayList<Book>();
    // private List<Book> books = new Vector<Book>(); // 여러 스레드에서 동시 접속 가능

    private Map<String, Book> books = new Hashtable<String, Book>();

    // 
    public BookManager(Scanner scanner){
        loadFromFile();
    }

    @Override 
    public void addItem(Book book){
        if(!books.containsKey(book.getId())){
            books.put(book.getId(), book);
            System.out.println("등록되었습니다.");  
        }else{
            System.out.println("기존 도서 목록이 교체됩니다.");            
            System.out.println(String.format("기존: %s \t %s \t %s", books.get(book.getId()).getId(), books.get(book.getId()).getTitle(), books.get(book.getId()).getAuther()));
            books.put(book.getId(), book);
            System.out.println(String.format("교체: %s \t %s \t %s", book.getId(), book.getTitle(), book.getAuther()));
        }              
    }

    @Override 
    public void displayAll(String Id){
        if(books.size()==0){
            System.out.println("등록된 도서가 없습니다.");
        }else if(Id.toLowerCase().equals("all")){
            System.out.println("ID \t 제목 \t 저자");
            Set<String> keys = books.keySet();
            for(String key: keys){
                Book book = books.get(key);
                System.out.println(String.format("%s \t %s \t %s", book.getId(), book.getTitle(), book.getAuther()));
            }
        }else{
            String key = String.format("%05d", Integer.parseInt(Id));
            if(books.containsKey(key)){
                Book book = books.get(key);
                System.out.println(String.format("%s \t %s \t %s", book.getId(), book.getTitle(), book.getAuther()));
            }else{
                System.out.println(String.format("해당 ID(%s)로 등록된 도서가 없습니다", key));
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
            for(Book book: books.values()){
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
                            book.setId(result[0]);
                            book.setTitle(result[1]);
                            book.setAuther(result[2]);
                            books.put(book.getId(), book);
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
