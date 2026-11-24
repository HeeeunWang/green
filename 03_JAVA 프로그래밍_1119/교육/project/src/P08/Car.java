package P08;
public class Car {
    Tire FLTire = new HankookTire();
    Tire FRTire = new HankookTire();
    Tire BLTire = new HankookTire();
    Tire BRTire = new HankookTire();

    Tire[] tires = {
        new HankookTire(),
        new HankookTire(),
        new HankookTire(),
        new HankookTire()
    };

    public void run(){
        FLTire.roll();
        FRTire.roll();
        BLTire.roll();
        BRTire.roll();
    }

    public void runTires(){
        for(Tire tire: tires){
            tire.roll();
        }
    }
}
