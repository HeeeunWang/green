package P04;
public class IfNestedExample {
    public static void main(String[] args) {
        int score = (int)(Math.random()*100)+1;
        // random -> (0 <= random < 1, 0 이상 1 미만)
        System.out.println("당신의 점수는? "+score+"입니다.");

        String grade;
        if(score>=90){
            if(score>=95) grade = "A+"; else{grade = "A";}
        }else if(score>=80){
            if(score>=85) grade = "B+"; else{grade = "B";}
        }else if(score>=70){
            if(score>=75) grade = "C+"; else{grade = "C";}
        }else if(score>=60){
            if(score>=65) grade = "D+"; else{grade = "D";}
        }else{
            grade = "F";
        }
        System.out.println("당신의 학점은? "+grade+"입니다.");
    }
}
