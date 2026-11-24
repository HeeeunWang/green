package PTest02;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDBHandler {
    public static void main(String[] args) {
        // DB 만들기
        // BookDBMaker();
        // DB 비우기
        BookDBCleaner();
    }

    public static void BookDBMaker(){
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/XE",
                "system",
                "1234"
            );
            // 테이블 존재 여부 확인
            String sqlTableCheck = "SELECT COUNT(*) FROM USER_TABLES WHERE TABLE_NAME = ?";

            PreparedStatement pstmt = conn.prepareStatement(sqlTableCheck);
            pstmt.setString(1, "BOOKS");
            ResultSet rs = pstmt.executeQuery();
            
            // 1 -> 테이블 존재 / 0 -> 테이블 없음
            if (rs.next() && rs.getInt(1) > 0) {
                // 기존 테이블 삭제
                pstmt = conn.prepareStatement("DROP TABLE BOOKS");
                pstmt.executeUpdate();
                System.out.println("기존 BOOKS TABLE을 삭제하였습니다.");
            }
            
            String sqlCreate = new StringBuilder()
            .append("CREATE TABLE BOOKS (")
            .append("BID        NUMBER(10)      CONSTRAINT BIDPK  PRIMARY KEY,")
            .append("BTITLE     VARCHAR2(50)    NOT NULL,")
            .append("BAUTHOR    VARCHAR2(50)    NOT NULL)")
            .toString();
            pstmt = conn.prepareStatement(sqlCreate);
            pstmt.executeUpdate();
            System.out.println("BOOKS TABLE을 생성하였습니다.");

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

    public static void BookDBCleaner(){
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/XE",
                "system",
                "1234"
            );
            // 테이블 존재 여부 확인
            String sqlTableCheck = "SELECT COUNT(*) FROM USER_TABLES WHERE TABLE_NAME = ?";

            PreparedStatement pstmt = conn.prepareStatement(sqlTableCheck);
            pstmt.setString(1, "BOOKS");
            ResultSet rs = pstmt.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                // 테이블 내용 비우기
                pstmt = conn.prepareStatement("DELETE FROM BOOKS");
                pstmt.executeUpdate();
                System.out.println("BOOKS TABLE을 비웠습니다.");
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
