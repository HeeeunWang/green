package P05;
public class AdvancedForExample {
    public static void main(String[] args) {
        int[] scores= {85, 41, 36, 59, 20};

        int sum = 0;
        for (int score: scores){
            sum += score;
        }
        System.out.println("점수 총 합: "+ sum);

        double avg = (double)sum/scores.length;
        System.out.println("점수 평균: "+ avg);

        
    }
}
