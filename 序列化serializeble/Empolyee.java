package 序列化serializeble;
/*ObjectOutputStream*/
import java.io.Serializable;

public class Empolyee implements Serializable {
    public String name;
    public String address;
    public transient int age;


    public void addressCheck(){
        System.out.println("Address check:" + name +"--" + address);
    }
}
