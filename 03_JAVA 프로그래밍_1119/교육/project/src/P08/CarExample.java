package P08;
public class CarExample {
    public static void main(String[] args) {
        Car myCar = new Car();
        System.out.println("----------------------");
        myCar.run();
        myCar.FLTire = new KumhoTire();
        myCar.FRTire = new KumhoTire();
        myCar.run();

        System.out.println("----------------------");
        myCar.runTires();
        myCar.tires[0] = new KumhoTire();
        myCar.tires[1] = new KumhoTire();
        myCar.runTires();
    }
    

}
