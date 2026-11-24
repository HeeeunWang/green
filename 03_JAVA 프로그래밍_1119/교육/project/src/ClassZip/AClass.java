package ClassZip;

public class AClass {
    public int field1; // 접근 가능!
    int field2; // 다른 패키지(src/CClass)에서 참조하면 접근 불가능, 같은 패키지(ClassZip) 다른 클래스(BClass)에서는 접근 가능
    private int field3; // 해당 클래스에서만 접근 가능

    // 생성자
    public AClass(){
        field1 = 1;
        field2 = 1;
        field3 = 1;

        method1();
        method2();
        method3();
    }

    public void method1(){
        System.out.println(field1);
    }
    void method2(){
        System.out.println(field2);
    }
    private void method3(){
        System.out.println(field3);
    }
}
