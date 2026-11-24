package P05;
public class ArrayInArrayExample {
    public static void main(){
        int[][] mathScores = new int[2][3];
        for(int i=0; i<mathScores.length; i++){
            for(int j=0; j<mathScores[i].length; j++){
                System.out.println(String.format("mathScores[%d][%d]= %d", i, j, mathScores[i][j]));
            }
        }
        System.out.println();

        int[][] englishScore = new int[2][];
        englishScore[0] = new int[2];
        englishScore[1] = new int[3];
        for(int i=0; i<englishScore.length; i++){
            for(int j=0; j<englishScore[i].length; j++){
                System.out.println(String.format("englishScore[%d][%d]= %d", i, j, englishScore[i][j]));
            }
        }
        System.out.println();

        int[][] javaScores= {{95, 84}, {92, 96, 80}};
        for(int i=0; i<javaScores.length; i++){
            for(int j=0; j<javaScores[i].length; j++){
                System.out.println(String.format("javaScores[%d][%d]= %d", i, j, javaScores[i][j]));
            }
        }
    }
}
