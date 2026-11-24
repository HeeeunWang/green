package ClassZip;

public class KumhoTire extends Tire {
    public KumhoTire(String location, int maxRotation){
        // Tire의 생성자에 입력 Tire(String location, int accumulatedRotation)
        super(location, maxRotation);
    }

    @Override 
    public boolean roll(){
        ++accumulatedRotation;
        if(accumulatedRotation<maxRotation){
            System.out.println(String.format("KumhoTire 수명: %d회", maxRotation-accumulatedRotation));
            return true;
        }else{
            System.out.println(String.format("*** %s KumhoTire 펑크 ***", location));
            return false;
        }
    }
}
