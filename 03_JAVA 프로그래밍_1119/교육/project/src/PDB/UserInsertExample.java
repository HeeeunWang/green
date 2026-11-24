package PDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserInsertExample {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@//localhost:1521/XE",
                    "system",
                    "1234"
            );
            
            // 매개변수화된 SQL문
            String sql = ""+
            "INSERT INTO USERS(USERID, USERNAME, USERPASSWORD, USERAGE, USEREMAIL) "+
            "VALUES(?, ?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "winter");
            pstmt.setString(2, "한겨울");
            pstmt.setString(3, "12345");
            pstmt.setInt(4, 25);
            pstmt.setString(5, "winter@mycompany.com");
            pstmt.executeUpdate();

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "summer");
            pstmt.setString(2, "한여름");
            pstmt.setString(3, "12345");
            pstmt.setInt(4, 25);
            pstmt.setString(5, "summer@mycompany.com");
            pstmt.executeUpdate();

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "autum");
            pstmt.setString(2, "한가을");
            pstmt.setString(3, "12345");
            pstmt.setInt(4, 25);
            pstmt.setString(5, "autum@mycompany.com");
            // pstmt.executeUpdate();

            // SQL문 실행
            int rows = pstmt.executeUpdate();
            System.out.println("저장된 행 수 "+ rows);

            if(rows == 1){
                ResultSet rs = pstmt.getGeneratedKeys();
                if(rs.next()){
                    int bno = rs.getInt(1);
                    System.out.println("저장된 bno: "+ bno);
                }else{
                    System.out.println("외않되");
                }
                rs.close();
            }

            // String sqlSelect = new StringBuilder()
            // .append("SELECT * ")
            // .append("FROM USERS ")
            // .append("WHERE USERID=? ")
            // .toString();

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
