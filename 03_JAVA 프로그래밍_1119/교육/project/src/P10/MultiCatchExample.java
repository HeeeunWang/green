package P10;
public class MultiCatchExample {
    public static void main(String[] args) {
        try{
            String data1 = args[0];
            String data2 = args[1];
            int values1 = Integer.parseInt(data1);
            int values2 = Integer.parseInt(data2);
            int result = values1 + values2;
            System.out.println(String.format("%d+%d=%d", data1, data1, result));            
        }catch(ArrayIndexOutOfBoundsException | NumberFormatException e){
            System.out.println("실행 매개값의 수가 부족하거나 숫자로 변환할 수 없습니다.");
        }catch(Exception e){ // 이 항목이 가장 마지막 exce
        // ption으로 들어가야함
            System.out.println("알 수 없는 예외가 발생했습니다.");
        }finally{
            System.out.println("다시 실행하세요.");
        }
    }
}
