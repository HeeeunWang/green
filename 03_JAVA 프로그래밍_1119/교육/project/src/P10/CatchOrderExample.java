package P10;
public class CatchOrderExample {
    public static void main(String[] args) {
        try{
            String data1 = args[0];
            String data2 = args[1];
            int values1 = Integer.parseInt(data1);
            int values2 = Integer.parseInt(data2);
            int result = values1 + values2;
            System.out.println(String.format("%d+%d=%d", data1, data1, result));            
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("실행 매개값의 수가 부족합니다.");
        }catch(Exception e){ // 이 항목이 가장 마지막 exception으로 들어가야함
            System.out.println("실행에 문제가 있습니다.");
        }finally{
            System.out.println("다시 실행하세요.");
        }
    }
}
