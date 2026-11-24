package P실습01;
public class Book {
    private int id;
    private String title;
    private String auther;
    
    public int getId(){return this.id;}
    public String getTitle(){return this.title;}
    public String getAuther(){return this.auther;}

    public void setId(int id){this.id = id;}
    public void setTitle(String title){this.title = title;}
    public void setAuther(String auther){this.auther = auther;}

    public String toFileString(){
        String str;
        str = id + "\t" + title + "\t" + auther + "\n";
        return str;
    }
}
