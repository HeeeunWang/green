package P05;
public class ArrayCopyExample {
    public static void main(String[] args) {
        String[] oldArray = {"java", "array", "copy"};
        String[] newArray = new String[5];

        System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
        for(int i=0; i<newArray.length; i++){
            System.out.println(newArray[i]);
        }

        System.out.println();

        String[] newArray2 = new String[5];
        System.arraycopy(oldArray, 1, newArray2, 2, 2);
        for(int i=0; i<newArray2.length; i++){
            System.out.println(newArray2[i]);
        }
    }
}
