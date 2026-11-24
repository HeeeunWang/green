package ClassZip;

public class Computer extends Calculator2 {
    // 컴파일러가 부모 클래스에 동일한 메서드가 있는지 검사
    // 오버라이딩 조건이 맞지 않으면 컴파일 오류가 발생
    @Override 
    public double areaCircle(double r){
        System.out.println("Computer 객체의 areaCircle() 실행");
        return Math.PI* r* r;
    }
}
