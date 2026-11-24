package P18;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class InputStreamReaderExample {
    public static void main(String[] args) throws Exception{
        try {
            InputStream is = System.in;
            Reader reader = new InputStreamReader(is);
            // chcp 65001 <터미널 설정을 변경해주기 
            // chcp 949 <이게 기존 설정

            int readCharNo;
            char[] cbuf = new char[100];
            while( (readCharNo=reader.read(cbuf))!= -1){
                String data = new String(cbuf, 0, readCharNo);
                System.out.println(data);
            }
            reader.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
