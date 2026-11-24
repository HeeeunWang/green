package P18;
import java.io.FileInputStream;

public class FileInputStreamExample {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("C:\\java_home\\project\\src\\FileInputStreamExample.java");
            int data;
            while((data=fis.read())!=-1){
                System.out.write(data); // byte단위로 씀. 아스키코드로 문자열 변환해줌.
                // System.out.print(data); 
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
