package P13;
import java.util.Objects;

public class Course<T>{
    private String name;
    private T[] students;

    public Course(String name, int capacity){
        this.name = name;
        this.students = (T[]) new Object[capacity];
    }

    public String getName(){return name;}
    public T[] getStudents(){return students;}
    public void add(T t){
        for(int i=0; i<students.length; i++){
            if(Objects.isNull(students[i])){
                students[i]=t;
                break;
            }
        }
    }
}