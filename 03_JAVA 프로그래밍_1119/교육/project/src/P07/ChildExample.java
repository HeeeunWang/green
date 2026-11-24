package P07;
import ClassZip.Child;
import ClassZip.Parent;
public class ChildExample {
    public static void main(String[] args) {
        Child child = new Child();
        Parent parent = child;

        parent.method1();
        parent.method2();
        // parent.method3(); // 호출불가능

        Parent panrent = new Child();
        panrent.field1 = "data1";
        panrent.method1();
        // parent.fidle2 = "data3" // 

        Child child2 = (Child) parent;
        child2.field2 = "yyyy";
        child2.method3();
    }
}
