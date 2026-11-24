package P13;
public class BoundedTypeParameterExample {
    public static void main(String[] args) {
        int result1 = compare(10, 20);
        int result2 = compare(4.5, 3);

        System.out.println(result1);
        System.out.println(result2);
    }

    public static <T extends Number> int compare(T t1, T t2){
        double v1 = t1.doubleValue();
        double v2 = t2.doubleValue();
        return Double.compare(v1, v2);
    }
}
