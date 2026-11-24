import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MembersDbAcc {
    public static Member logIn(Scanner scanner){
        Connection conn = null;
        try {
            // DB 연동
                Class.forName("oracle.jdbc.OracleDriver");

                conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/XE",
                    "system",
                    "1234"
                );
            String mId;
            String mPw;
            do{
                // 아이디 입력
                System.out.print("ID> ");
                mId = scanner.nextLine();
                if (mId.equals("")) {System.out.println("잘못입력하셨습니다."); break;}

                // 비밀번호 입력
                System.out.print("PW> ");
                mPw = scanner.nextLine();

                // DB는 존재한다 생각하고..
                String sqlSelect = new StringBuilder()
                .append("SELECT * FROM MEMBERS WHERE MID = ?")
                .toString();
                PreparedStatement pstmt = conn.prepareStatement(sqlSelect);
                pstmt.setString(1, mId);
                // 아이디 존재 확인
                ResultSet rs = pstmt.executeQuery();
                if(rs.next()){
                    if (mPw.equals(rs.getString("MPW"))){
                        Member member = new Member();
                        member.setMId(rs.getString("MID"));
                        member.setMPw(rs.getString("MPW"));
                        member.setMName(rs.getNString("MNAME"));
                        member.setMNumber(rs.getString("MNUMBER"));
                        member.setMRentAvail(rs.getInt("MRENTAVAIL"));
                        return member;
                    }else{
                        System.out.println("비밀번호를 확인해주세요.");
                        continue;
                    }
                }else{
                    System.out.println("아이디가 존재하지 않습니다.");
                    continue;
                }
            }while(true);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(SQLException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(conn!=null){
                try{
                    conn.close();
                    System.out.println("로그인 완료!");
                } catch(SQLException e) {}
            }
        }
        // 예외 발생시 null 반환
        return null;
    }

    public static void SignUp(Scanner scanner){
        Connection conn = null;
        try {
            String mId;
            String mPw;
            String mName;
            String mNumber;
            // Date date;
            int mRentAvail = 1;

            // DB 연동
                Class.forName("oracle.jdbc.OracleDriver");

                conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/XE",
                    "system",
                    "1234"
                );
            do{
                // 아이디 입력
                System.out.print("ID> ");
                mId = scanner.nextLine();
                if(mId == "") {System.out.println("잘못입력하셨습니다."); break;}

                
                // DB는 존재한다 생각하고..
                String sqlSelect = new StringBuilder()
                .append("SELECT * FROM MEMBERS WHERE MID = ?")
                .toString();
                PreparedStatement pstmt = conn.prepareStatement(sqlSelect);
                pstmt.setString(1, mId);
                // 아이디 중복 확인
                ResultSet rs = pstmt.executeQuery();
                if(rs.next()){
                    System.out.println("이미 존재하는 아이디입니다.");
                    continue;
                }

                // 비밀번호 입력
                System.out.print("PW> ");
                mPw = scanner.nextLine();
                if(mId == "") {System.out.println("잘못입력하셨습니다."); continue;}
                
                // 이름 입력
                System.out.print("이름> ");
                mName = scanner.nextLine();
                if(mId == "") {System.out.println("잘못입력하셨습니다."); continue;}

                // 전화번호 입력
                System.out.print("전화번호> ");
                mNumber = scanner.nextLine();
                if(mId == "") {System.out.println("잘못입력하셨습니다."); continue;}

                String sqlInsert = new StringBuilder()
                .append("INSERT INTO MEMBERS ")
                .append("(MID, MPW, MNAME, MNUMBER, MSIGNUP, MRENTAVAIL)")
                .append("VALUES(?, ?, ?, ?, ?, ?)")
                .toString();

                pstmt = conn.prepareStatement(sqlInsert);
                pstmt.setString(1, mId);
                pstmt.setString(2, mPw);
                pstmt.setString(3, mName);
                pstmt.setString(4, mNumber);
                pstmt.setDate(5, new Date(System.currentTimeMillis()));
                pstmt.setInt(6, mRentAvail);
                pstmt.executeUpdate();
                break;
            }
            while(true);

        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(SQLException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(conn!=null){
                try{
                    conn.close();
                    System.out.println("회원 가입 완료!");
                } catch(SQLException e) {}
            }
        }
        
    }
}
