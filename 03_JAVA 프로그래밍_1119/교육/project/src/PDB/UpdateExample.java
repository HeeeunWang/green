package PDB;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateExample {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/XE",
                "system",
                "1234"
            );

            String sqlUpdate = new StringBuilder()
            .append("UPDATE BOARDS SET ")
            .append("BFILENAME = ?, ")
            .append("BFILEDATA = ?, ")            
            .append("BTITLE = ?, ")
            .append("BCONTENTS = ? ")
            .append("WHERE BNO = ?")
            .toString();

            PreparedStatement pstmt = conn.prepareStatement(sqlUpdate);
            pstmt.setString(1, "사기.jpg");
            pstmt.setBlob(2, new FileInputStream("C:/java_home/project/src/사기.jpg"));
            pstmt.setString(3, "우사기");
            pstmt.setString(4, "우사기로 할래");
            pstmt.setInt(5, 2);
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
