package P13;
import java.util.Arrays;

public class WildCardExample {
    public static void registerCourse(Course<?> course){
        System.out.println(course.getName()+ " 수강생: "+ Arrays.toString((course.getStudents())));
    }

    public static void main(String[] args) {
        Course<Person> personCourse = new Course<Person>("일반인 과정", 5);
        personCourse.add(new Person("일반인"));

        registerCourse(personCourse);
    }   
    
}
