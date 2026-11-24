package P11;
import java.util.Arrays;
import java.util.Objects;
public class EqualsAndDeepEqualsExample {
    public static void main(String[] args) {
        // Integer o1 = new Integer(1000); // 이전에는 이런방식도 됐는데 지금은 막았음
        Integer o1 = 1000;
        Integer o2 = 1000;
        System.out.println(Objects.equals(o1, o2)); // thin equals > 값이 바로 저장되니까 true
        System.out.println(Objects.equals(o1, null));
        System.out.println(Objects.equals(null, o2));
        System.out.println(Objects.equals(null, null));
        System.out.println(Objects.deepEquals(o1, o2)+"\n");

        Integer[] arr1 = {1, 2};
        Integer[] arr2 = {1, 2};
        System.out.println(Objects.equals(arr1, arr2)); // thin equals > 값이 바로 저장되니까 true
        System.out.println(Objects.deepEquals(arr1, arr2));
        System.out.println(Arrays.deepEquals(arr1, arr2));
        System.out.println(Objects.deepEquals(arr1, null));
        System.out.println(Objects.deepEquals(null, arr2));
        System.out.println(Objects.deepEquals(null, null));        
    }
}
