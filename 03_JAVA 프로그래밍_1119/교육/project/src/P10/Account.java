package P10;
public class Account {
    private long balance;
    public Account(){}
    public long getBalance(){
        return balance;
    }
    public void deposit(int money){
        balance += money;
    }
    public void withdraw(int money) throws BalanceInsufficientExample {
        if (balance<money){
            throw new BalanceInsufficientExample(String.format("잔고부족: %d 부족함", (money-balance)));
        }
        balance -= money;
    }
}
