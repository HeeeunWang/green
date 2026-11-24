package ClassZip;

public class Car {
    public String color;
    public int cc;
    public String company = "현대자동차";
    public String model;
    public int maxSpeed;

    public Car(){

    }
    public Car(String model){
        this.model = model;
    }
    public Car(String model, String color){
        this.model = model;
        this.color = color;
    }
    public Car(String model, String color, int maxSpeed){
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
    public  Car(String color, int cc){
        this.color = color;
        this.cc = cc;
    }
    
}
