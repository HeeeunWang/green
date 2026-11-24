package P18;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileOutputStreamExample {
    public static void main(String[] args) {
        try {
            String originalFileName = "C:\\java_home\\project\\src\\사기.jpg";
            String targetFileName = "C:/java_home/project/src/복제_사기.jpg";

            FileInputStream fis = new FileInputStream(originalFileName);
            FileOutputStream fos = new FileOutputStream(targetFileName);

            int readByteNo;
            byte[] readBytes = new byte[100];
            int size =0 ;;
            while( (readByteNo= fis.read(readBytes)) != -1 ){
                size += readByteNo; // 파일 크기 확인
                // System.out.print(readByteNo+" ");
                fos.write(readBytes, 0, readByteNo);
            }
            System.out.println(size + "byte");
            fos.flush();
            fos.close();
            fis.close();

            System.out.println("종료");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
