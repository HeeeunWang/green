package ClassZip;

public class BClass {
    // 생성자
    public BClass(){
        AClass a = new AClass();
        a.field1 = 1;
        a.field2 = 1;
        // a.field3 = 1; // private은 해당 클래스 내부에서만 사용

        a.method1();
        a.method2();
        // a.method3(); // private은 해당 클래스 내부에서만 사용
    }
}
