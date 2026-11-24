package ClassZip;

public class Car2 {
    public String company = "현대자동차";
    public String model;
    public String color;
    public int maxSpeed;

    public Car2(){}

    public Car2(String model){
        this(model, "파랑", 70); 
        // Strins String int로 정의된 생성자가 있어야 이 형식 사용 가능
    }

    public Car2(String model, String color){
        this(model, color, 80);
    }

    public Car2(String model, String color, int maxSpeed){
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

}
