package P07;
import ClassZip.*;
public class InstanceofExample {
    public static void method1(Parent parent){
        if (parent instanceof Child){
            // parent가 참조하는 객체가 실제로 어떤 형인지 확인하고!!
            Child child = (Child) parent;
            System.out.println("method1 - child로 변환 성공");
        }else{
            System.out.println("method1 - child로 변환 실패");
        }
    }
    public static void method2(Parent parent){
        Child child = (Child)parent;
        System.out.println("method2 - child로 변환 성공");
    }
    public static void main(String[] args) {
        Parent parentA = new Child();
        method1(parentA);
        method2(parentA);

        Parent parentB = new Parent();
        method1(parentB);
        method2(parentB); // 에러
    }
}
