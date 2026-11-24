import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibraryDBHandler {
    public static void main(String[] args) {
        // DB 만들기
        DBDrop("RENTALS");
        DBDrop("MEMBERS");
        DBDrop("BOOKS");
        
        DBMaker("BOOKS");
        DBMaker("MEMBERS");
        DBMaker("RENTALS");
        // DB 비우기
        // BookDBCleaner();
    }

    public static void DBMaker(String DbName){
        String UpperDbName = DbName.toUpperCase();
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/XE",
                "system",
                "1234"
            );
            
            String sqlCreate = DBSetting(UpperDbName);
            if(sqlCreate==null){
                System.out.println("잘못된 테이블명입니다.");
            }else{
                PreparedStatement pstmt = conn.prepareStatement(sqlCreate);
                pstmt.executeUpdate();
                System.out.println(UpperDbName+" TABLE을 생성하였습니다.");
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

    public static void DBCleaner(String DbName){
        String UpperDbName = DbName.toUpperCase();
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
            pstmt.setString(1, UpperDbName);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                // 테이블 내용 비우기
                pstmt = conn.prepareStatement("DELETE FROM "+ UpperDbName);
                pstmt.executeUpdate();
                System.out.println(UpperDbName +" TABLE을 비웠습니다.");
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

    public static String DBSetting(String DbName){
        String UpperDbName = DbName.toUpperCase();
        switch (UpperDbName) {
            case "BOOKS":
                String sqlBooks = new StringBuilder()
                .append("CREATE TABLE BOOKS (")
                .append("BID        NUMBER(10)      CONSTRAINT BIDPK    PRIMARY KEY,") // 도서 ID
                .append("ISBN       VARCHAR2(20),") // ISBN
                .append("BTITLE     VARCHAR2(50)    NOT NULL,") // 제목
                .append("BAUTHOR    VARCHAR2(50)    NOT NULL,") // 저자
                .append("BPUB       VARCHAR2(30),") // 출판사
                .append("BRENTAVAIL NUMBER(1)       DEFAULT 1    NOT NULL)") // 대여가능여부: 대여가능 1, 대여불가능 0
                .toString();
                return sqlBooks;
            case "MEMBERS":
                String sqlMembers = new StringBuilder()
                .append("CREATE TABLE MEMBERS (")
                .append("MID        VARCHAR2(20)    CONSTRAINT MIDPK  PRIMARY KEY,") // 회원 ID
                .append("MPW        VARCHAR2(30)    NOT NULL,") // 비밀번호
                .append("MNAME      VARCHAR2(30)    NOT NULL,") // 이름
                .append("MNUMBER    VARCHAR2(30)    NOT NULL,") // 전화번호
                .append("MSIGNUP    DATE            NOT NULL,") // 가입일
                .append("MRENTAVAIL NUMBER(1)       DEFAULT 1    NOT NULL)") // 대여가능여부(대여정지여부): 대여가능 1, 대여불가능 0
                .toString();
                return sqlMembers;
            case "RENTALS":
                String sqlRentals = new StringBuilder()
                .append("CREATE TABLE RENTALS (")
                .append("RID        NUMBER(10)      CONSTRAINT RIDPK        PRIMARY KEY,")
                .append("MID        VARCHAR2(20)    CONSTRAINT RID_MIDFK    REFERENCES  MEMBERS (MID),")
                .append("BID        NUMBER(10)      CONSTRAINT RID_BIDFK    REFERENCES  BOOKS (BID),")
                .append("RENTDATE   DATE            NOT NULL,")
                .append("DUEDATE    DATE            NOT NULL,")
                .append("RETURNDATE DATE,")
                .append("OVERDUE    NUMBER(1)       DEFAULT 0    NOT NULL)") // 연체여부: 연체 1, 미연체 0
                .toString();
                return sqlRentals;
            default:
                return null;
        }
    }

    public static void DBDrop(String DbName){
        String UpperDbName = DbName.toUpperCase();
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
            pstmt.setString(1, UpperDbName);
            ResultSet rs = pstmt.executeQuery();
            
            // 1 -> 테이블 존재 / 0 -> 테이블 없음
            if (rs.next() && rs.getInt(1) > 0) {
                // 기존 테이블 삭제
                pstmt = conn.prepareStatement("DROP TABLE "+ UpperDbName);
                pstmt.executeUpdate();
                System.out.println("기존 "+UpperDbName+" TABLE을 삭제하였습니다.");
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
