package P10;
public class TryCatchfinallyRuntimeExceptionExample {
    public static void main() {        
        String[] strArray = {null, "3"};
        insertArray(null);
        insertArray(strArray);

        String[] strArray2 = new String[] {"1", "2"};
        add(strArray2);
        strArray2 = new String[2];
        add(strArray2);
        add(new String[] {"1"});
        
    }

    public static void insertArray(String[] strArray){
        try {
            String data1 = strArray[0];
            String data2 = strArray[1];
            System.out.println(String.format("%s, %s", data1, data2));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("실행 매개값의 수가 부족합니다.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void add(String[] strArray){
        try {
            int value1 = Integer.parseInt(strArray[0]);
            int value2 = Integer.parseInt(strArray[1]);
            int result = value1 + value2;
            System.out.println(String.format("%d + %d = %d", value1, value2, result));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("실행 매개값의 수가 부족합니다.");
        } catch (NumberFormatException e) {
            System.out.println("숫자로 변환할 수 없습니다.");
        } catch (Exception e) {
            System.out.println(e);
        } finally{
            System.out.println("다시 실행하세요.");
        }
    }
}

