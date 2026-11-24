package ClassZip;

public class DmbCellPhone extends CellPhone {
    // 필드
    public int channel;

    // 생성자
    public DmbCellPhone(String model, String color, int channel){
        this.model = model;
        this.color = color;
        this.channel = channel;
    }

    // 메소드
    public void turnOnDmb(){
        System.out.println(String.format("채널 %d번 DMB 방송 수신을 시작합니다.", channel));
    }
    public void changeChannelDmb(int channel){
        this.channel = channel;
        System.out.println(String.format("채널 %d번으로 바꿉니다.", channel));
    }
    public void turnOffDmb(){
        System.out.println("DMB 방송 수신을 멈춥니다.");
    }
}
