package P07;
import ClassZip.AClass;
public class CClass {
    public CClass(){
        AClass a = new AClass();
        a.field1 = 1;
        // a.field2 = 1; // 다른 패키지(폴더)에 위치한 default는 접근 불가
        // a.field3 = 1; // private은 해당 클래스(AClass) 내부에서만 접근 가능

        a.method1();
        // a.method2(); // 다른 패키지(폴더)에 위치한 default는 접근 불가
        // a.method3(); // private은 해당 클래스(AClass) 내부에서만 접근 가능
    }
}
