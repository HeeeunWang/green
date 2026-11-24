package P13;
public class ChildProductAndStorageExample {
    public static void main(String[] args) {
        ChildProduct<Tv, String, String> product = new ChildProduct<>();
        product.setKind(new Tv());
        product.setModel("SmartTV");
        product.setCompany("Samsung");
    
        Storage<Tv> storage = new StorageImpl<Tv>(100);

    }
}

class Product<T, M>{
    private T kind;
    private M model;

    public T getKind(){return this.kind;}
    public M getModel(){return this.model;}

    public void setKind(T kind){this.kind= kind;}
    public void setModel(M model){this.model = model;}
}

class ChildProduct<T, M, C> extends Product<T, M>{
    private C company;
    public C getCompany(){return this.company;}
    public void setCompany(C company){this.company = company;}
}

interface Storage<T>{
    public void add(T item, int index);
    public T get(int index);
}

class StorageImpl<T> implements Storage<T>{
    private T item;
    private int index;

    @Override 
    public void add(T item, int index){
        this.item = item;
        this.index = index;
    }

    @Override 
    public T get(int index){
        return this.item;
    }
}

class Tv {
    String tv;
}