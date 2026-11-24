package PTest02;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BookManager implements Manageable{
    // 도서 목록: 도서 객체를 LIST로 관리
    // private List<Book> books = new ArrayList<Book>();
    private Map<Integer, Book> books = new Hashtable<Integer, Book>();

    // 도서 목록 txt 파일의 경로
    // private String DBBooksTable = new StringBuilder().append("BOOKS").toString();

    // 생성자: bookmanager 
    public BookManager(){
        // loadFromDB(); // -> main에서 호출할것이라 생략
    }
    // 도서 목록 DB 테이블명을 받아올 수 있는 생성자
    // public BookManager(String DBBooksTable){
    //     this.DBBooksTable = DBBooksTable;
    // }    
    
    // 데이터 추가
    @Override 
    public void addItem(Book book){
        // 없는 키라면 등록
        if(!this.books.containsKey(book.getId())){
            this.books.put(book.getId(), book);
            System.out.println("등록되었습니다.");  
        }else{
            System.out.println("기존 도서 목록이 교체됩니다.");            
            System.out.println(String.format("기존: %d \t %s \t %s", 
                this.books.get(book.getId()).getId(), 
                this.books.get(book.getId()).getTitle(), 
                this.books.get(book.getId()).getAuthor()));
            this.books.put(book.getId(), book);
            System.out.println(String.format("교체: %d \t %s \t %s", 
                book.getId(), 
                book.getTitle(), 
                book.getAuthor()));
        }   
    }   

    // 전체 목록 출력
    @Override 
    public void displayAll(){
        // 도서 목록의 모든 도서 객체 정보를 콘솔에 출력
        if(this.books.size()==0){
            // 등록된 도서가 없는 경우
            System.out.println("등록된 도서가 없습니다.");
        }else{
            // Set<Integer> keys = this.books.keySet();
            // 오름차순으로 정렬하려고
            List<Integer> keys = new ArrayList<>(books.keySet());
            Collections.sort(keys);
            System.out.println("| ---------------------------------");
            for(Integer key: keys){
                Book book = this.books.get(key);
                System.out.println(String.format("%s \t %s \t %s \t ", book.getId(), book.getTitle(), book.getAuthor()));
            }
            System.out.println("| ---------------------------------");
        }
    }

    public void displaId(String strId){
        if(this.books.size()==0){
            // 등록된 도서가 없는 경우
            System.out.println("등록된 도서가 없습니다.");
        }else{
            try {
                Integer key = Integer.parseInt(strId);
                System.out.println("| ---------------------------------");
                if(books.containsKey(key)){
                    Book book = books.get(key);
                    System.out.println(String.format("%s \t %s \t %s \t", book.getId(), book.getTitle(), book.getAuthor()));
                }else{
                    System.out.println(String.format("해당 ID(%s)로 등록된 도서가 없습니다", key));
                }
                System.out.println("| ---------------------------------");
            } catch (Exception e) {
                System.out.println("ID 입력을 잘못하셨습니다.");
            }
        }
    }

    // DB로 데이터 저장
    @Override
    public void saveToDB(){
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/XE",
                "system",
                "1234"
            );
            // DB 비우기
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM BOOKS");
            pstmt.executeUpdate();

            String sqlInsert = new StringBuilder()
            .append("INSERT INTO BOOKS ")
            .append("(BID, BTITLE, BAUTHOR) ")
            .append("VALUES(?, ?, ?)")
            .toString();

            pstmt = conn.prepareStatement(sqlInsert);

            Set<Integer> keys = this.books.keySet();
            for(Integer key: keys){
                Book book = this.books.get(key);
                pstmt.setInt(1, book.getId());
                pstmt.setString(2, book.getTitle());
                pstmt.setString(3, book.getAuthor());
                pstmt.executeUpdate();
            }
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(conn!=null){
                try{
                    conn.close();
                    System.out.println("연결 끊기");
                } catch(SQLException e) {}
            }
        }
    }

    // DB에서 데이터 로드
    @Override 
    public void loadFromDB(){
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/XE",
                "system",
                "1234"
            );
            // DB는 존재한다 생각하고..
            String sqlSelect = new StringBuilder()
            .append("SELECT * FROM BOOKS ORDER BY BID ASC")
            .toString();
            PreparedStatement pstmt = conn.prepareStatement(sqlSelect);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                do{
                    Book book = new Book();
                    book.setId(rs.getInt("BID"));
                    book.setTitle(rs.getString("BTITLE"));
                    book.setAuthor(rs.getString("BAUTHOR"));
                    this.books.put(book.getId(), book);
                } while (rs.next());
                System.out.println("도서 목록 생성을 완료하였습니다.");
                System.out.println("LIBRARY SYSTEM을 실행합니다.");
                System.out.println();
            }else{
                System.out.println("저장된 도서 목록이 없습니다: not Found BOOKS DB");
                System.out.println("LIBRARY SYSTEM을 실행합니다.");
                System.out.println();
            }
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(conn!=null){
                try{
                    conn.close();
                    System.out.println("연결 끊기");
                } catch(SQLException e) {}
            }
        }
    }
}