package P04;
public class ForMultiplicationTableExample {
    public static void main(String[] args) {
        // 2단부터 9단
        for (int m=2; m<10; m++){
            System.out.println(String.format("-- %d단----------------", m));
            for (int n=1; n<10; n++){
                System.err.println(String.format("%d x %d = %d", m, n, m*n));
            }
        }

        // 9단부터 2단
        for (int m=9; m>1; m--){
            System.out.println(String.format("-- %d단----------------", m));
            for (int n=1; n<10; n++){
                System.err.println(String.format("%d x %d = %d", m, n, m*n));
            }
        }
    }
}
