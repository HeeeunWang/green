package P11;
import java.util.Arrays;
import java.util.Random;

public class RandomExample {
    public static void main(String[] args) {
        //선택번호
        int[] selectNumber = new int[6];
        Random random = new Random(84); // seed
        System.out.println("선택 번호: ");
        for(int i=0;i<selectNumber.length;i++){
            selectNumber[i] = random.nextInt(45)+ 1; // bound
            System.out.print(selectNumber[i]+ ((i==selectNumber.length-1)? "":","));
        }
        System.out.println();

        //당첨번호
        int[] winningNum = new int[6];
        random = new Random(226);
        System.out.println("당첨 번호: ");
        for(int i=0;i<winningNum.length;i++){
            winningNum[i] = random.nextInt(45)+ 1; // bound
            System.out.print(winningNum[i]+ ((i==winningNum.length-1)? "":","));
        }
        System.out.println();

        // 당첨여부
        Arrays.sort(selectNumber);
        Arrays.sort(winningNum);        
        // selectNumber.equals(winningNum); <주소값만 비교하니까 false
        if(Arrays.equals(selectNumber, winningNum)){
            System.out.println("당첨이요");
        }else{
            System.out.println("미당첨이요");
        }
    }
}
