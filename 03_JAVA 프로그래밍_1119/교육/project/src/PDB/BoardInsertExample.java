package PDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoardInsertExample {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/XE",
                "system",
                "1234"
            );

            String sqlInsert = new StringBuilder()
            .append("INSERT INTO BOARDS ")
            .append("(BNO, BTITLE, BCONTENTS) ")
            .append("VALUES(?, ?, ?)")
            .toString();

            PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
            pstmt.setInt(1, 3);
            pstmt.setString(2, "눈사람");
            pstmt.setString(3, "눈으로 만든 사람");            
            int rows = pstmt.executeUpdate();
            System.out.println("저장된 행 수 "+ rows);

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
