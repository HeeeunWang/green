package P07;
import ClassZip.DmbCellPhone;

public class DmbCellPhoneExample {
    public static void main(String[] args) {
        DmbCellPhone dmb = new DmbCellPhone("자바폰", "검정", 10);

        // CellPhone으로부터 상속받은 필드
        System.out.println("모델: "+ dmb.model);
        System.out.println("색상: "+ dmb.color);

        // DmbCellPhone의 필드
        System.out.println("채널: "+ dmb.channel);

        // CellPhone으로부터 상속받은 메소드
        dmb.powerOn();
        dmb.bell();
        dmb.sendVoice("여보세요");
        dmb.receiveVoice("안녕하세요! 홍길동입니다.");
        dmb.sendVoice("아 네, 반갑습니다.");
        dmb.hangUp();

        // DmbCellPhone의 메소드
        dmb.turnOnDmb();
        dmb.changeChannelDmb(12);
        dmb.turnOffDmb();
    }
}
