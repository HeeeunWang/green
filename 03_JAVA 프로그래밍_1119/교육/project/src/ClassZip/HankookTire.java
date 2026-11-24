package ClassZip;

public class HankookTire extends Tire{
    public HankookTire(String location, int maxRotation){
        // Tire의 생성자에 입력 Tire(String location, int accumulatedRotation)
        super(location, maxRotation);
    }

    @Override 
    public boolean roll(){
        ++accumulatedRotation;
        if(accumulatedRotation<maxRotation){
            System.out.println(String.format("HankookTire 수명: %d회", maxRotation-accumulatedRotation));
            return true;
        }else{
            System.out.println(String.format("*** %s HankookTire 펑크 ***", location));
            return false;
        }
    }
}
