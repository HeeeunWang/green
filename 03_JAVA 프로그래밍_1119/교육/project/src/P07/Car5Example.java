package P07;
import ClassZip.Car5;
import ClassZip.HankookTire;
import ClassZip.KumhoTire;
public class Car5Example {
    public static void main(String[] args) {
        Car5 car = new Car5();
        for(int i=1; i<=5; i++){
            int[] problemLocation = car.run();
            for (int j=0; j<problemLocation.length; j++){
                switch (problemLocation[j]) {
                    case 1:
                        System.out.println("i: "+i);
                        System.out.println(car.tires[0].location+ " HankookTire로 교체");
                        car.tires[0] = new HankookTire(car.tires[0].location, 15);
                        break;
                    case 2:
                        System.out.println("i: "+i);
                        System.out.println(car.tires[1].location+ " KumhoTire 교체");
                        car.tires[1] = new KumhoTire(car.tires[1].location, 13);
                        break;
                    case 3:
                        System.out.println("i: "+i);
                        System.out.println(car.tires[2].location+ " HankookTire로 교체");
                        car.tires[2] = new HankookTire(car.tires[2].location, 14);
                        break;
                    case 4:
                        System.out.println("i: "+i);
                        System.out.println(car.tires[3].location+ " KumhoTire 교체");
                        car.tires[3] = new KumhoTire(car.tires[3].location, 17);
                        break;
                }
            }            
            System.out.println("----------------------------------------------");
        }
        System.out.println(car.tires[0].location+ " 타이어 수명: "+(car.tires[0].maxRotation-car.tires[0].accumulatedRotation));
        System.out.println(car.tires[1].location+ " 타이어 수명: "+(car.tires[1].maxRotation-car.tires[1].accumulatedRotation));
        System.out.println(car.tires[2].location+ " 타이어 수명: "+(car.tires[2].maxRotation-car.tires[2].accumulatedRotation));
        System.out.println(car.tires[3].location+ " 타이어 수명: "+(car.tires[3].maxRotation-car.tires[3].accumulatedRotation));
    }
}
