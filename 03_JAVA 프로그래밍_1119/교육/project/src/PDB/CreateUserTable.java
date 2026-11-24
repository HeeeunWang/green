package PDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateUserTable {
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
            .append("DROP TABLE USERS")
            .toString();
            PreparedStatement pstmt = conn.prepareStatement(sqlDelTable);
            pstmt.executeUpdate();

            String sqlCreate = new StringBuilder()
            .append("CREATE TABLE USERS (")
            .append("USERID     VARCHAR2(20)        CONSTRAINT UPK  PRIMARY KEY,")
            .append("USERNAME   VARCHAR2(20)        NOT NULL,")
            .append("USERPASSWORD   VARCHAR2(30)    NOT NULL,")
            .append("USERAGE    NUMBER(10),")
            .append("USEREMAIL  VARCHAR2(50))")
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
