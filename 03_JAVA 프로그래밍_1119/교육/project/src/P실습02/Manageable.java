package P실습02;
public interface Manageable {
    void addItem(Book book);
    void displayAll(String ID);
    void saveToFile();
    void loadFromFile();
}
