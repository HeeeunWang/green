package PDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateBoardTable {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/XE",
                "system",
                "1234"
            );
            
            String sqlDelTable = new StringBuilder()
            .append("DROP TABLE BOARDS")
            .toString();
            PreparedStatement pstmt = conn.prepareStatement(sqlDelTable);
            pstmt.executeUpdate();

            String sqlCreate = new StringBuilder()
            .append("CREATE TABLE BOARDS (")
            .append("BNO        NUMBER(10)      CONSTRAINT BPK  PRIMARY KEY,")
            .append("BTITLE     VARCHAR2(50)    NOT NULL,")
            .append("BCONTENTS  VARCHAR2(100),")
            .append("BFILENAME  VARCHAR2(20),")
            .append("BFILEDATA  bLOB)")
            .toString();
            pstmt = conn.prepareStatement(sqlCreate);
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
