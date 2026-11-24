package P07;
import ClassZip.Computer;
import ClassZip.Calculator2;
public class CompurerExample {
    public static void main(String[] args) {
        int r = 10;

        Computer com = new Computer();
        System.out.println("원의 면적: "+ com.areaCircle(r));
        
        Calculator2 cal = new Calculator2();
        System.out.println("원의 면적: "+ cal.areaCircle(r));
    }
}
