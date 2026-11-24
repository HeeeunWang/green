package ClassZip;

public class Tire {
    public int maxRotation;
    public int accumulatedRotation;
    public String location;

    // 생성자
    public Tire(String location, int maxRotation){
        this.location = location;
        this.maxRotation = maxRotation;
    }

    // 메소드
    public boolean roll(){
        ++accumulatedRotation;
        if(accumulatedRotation<maxRotation){
            System.out.println(String.format("Tire 수명: %d회", maxRotation-accumulatedRotation));
            return true;
        }else{
            System.out.println(String.format("*** %s Tire 펑크 ***", location));
            return false;
        }
    }
    
}
