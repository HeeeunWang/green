package P11;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
public class KeyboardToStringExample {
    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[100];

        System.out.print("입력: ");
        int readByteNo = System.in.read(bytes);

        String str = new String(bytes, 0, readByteNo-2, StandardCharsets.UTF_8);
        System.out.println(str);
    }
}
