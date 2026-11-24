package ClassZip;

public class Car5 {
    public Tire[] tires = {
        new Tire("앞왼쪽",6),
        new Tire("앞오른쪽",3),
        new Tire("뒤왼쪽",3),
        new Tire("뒤오른쪽", 4)
    };
    // public Tire frontLeftTire = new Tire("앞왼쪽", 6);
    // public Tire frontRightTire = new Tire("앞오른쪽", 2);
    // public Tire backLeftTire = new Tire("뒤왼쪽", 2);
    // public Tire backRightTire = new Tire("뒤오른쪽", 4);

    public int[] run(){
        // 아래처럼 하면 바퀴 네개가 다 구르지 못함! 
        // frontLeftTire에서 false가 뜨면 나머지 바퀴는 roll하지 못하게됨!
        // System.out.println("[자동차가 달립니다.]");
        // if(frontLeftTire.roll()==false){stop(); return 1;}
        // if(frontRightTire.roll()==false){stop(); return 2;}
        // if(backLeftTire.roll()==false){stop(); return 3;}
        // if(backRightTire.roll()==false){stop(); return 4;}

        // 배열로 리턴값 쌓아서 보내주면 됨 4개 고정이니까 고정위치로 넣으면 편할듯
        int[] result = new int[4];
        System.out.println("[자동차가 달립니다.]");
        for(int i=0; i<tires.length; i++){
            if(tires[i].roll()==false){stop(); result[i]=i+1;};
        }        
        return result;       
    }

    public void stop(){
        System.out.println("[자동차가 멈춥니다.]");
    }
}
