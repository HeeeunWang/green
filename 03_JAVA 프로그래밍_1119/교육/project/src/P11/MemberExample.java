package P11;
public class MemberExample {
    public static void main(String[] args) {
        Member obj1 = new Member("blue");
        Member obj2 = new Member("blue");
        Member obj3 = new Member("red");

        // System.out.println(obj1.id.equals(obj2.id));
        // System.out.println(obj1.equals(obj2));
        // equals를 재정의하면 > true true
        // equals를 재정의하지 않으면 > true false

        if(obj1.equals(obj2)){
            System.out.println("obj1과 obj2는 동등합니다.");
        }else{
            System.out.println("obj1과 obj2는 동등하지 않습니다.");
        }

        if(obj1.equals(obj3)){
            System.out.println("obj1과 obj3는 동등합니다.");
        }else{
            System.out.println("obj1과 obj3는 동등하지 않습니다.");
        }
    }
}
