package P04;
public class SwitchValueExample {
    public static void main(String[] args) {
        String grade = "F";

        int score = switch(grade){
            case "A" -> 100;
            case "B" -> {
                int result = 100 - 20;
                yield result;
            }
            case "C" -> {
                int result = 100 - 30;
                yield result;
            }
            case "D" -> 60;
            case "F" -> 50;
            default -> 00;
        };

        System.out.println("등급 "+grade+"의 점수는 "+score+"입니다.");
        System.out.println(String.format("등급 %s의 점수는 %d입니다.", grade, score));
    }
}
