package P08;
public class MyClassB implements MyInterface{
    @Override 
    public void method1(){
        System.out.println("MyClassB-method1 실행");
    }

    @Override 
    public void method2(){
        System.out.println("MyClassB-method2 실행");
    }
}

// public class MyClassB extends MyClassA{
//     @Override 
//     public void method2(){
//         System.out.println("MyClassB-method2 실행");
//     }
// }
// 이대로 하면 MyClassA를 상속받아서 method1을 받아올 수 있음
