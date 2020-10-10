package 序列化serializeble;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/*反序列化*/
public class DeserializebleDemo {
    public static void main(String[] args) {
        Empolyee e = null;
        try {
            //创建反序列化流
            FileInputStream fileIn = new FileInputStream("C:\\Users\\ZZY\\Desktop\\JavaNote\\test\\employee.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            //读取一个对象
            e = (Empolyee) in.readObject();
            //释放资源
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            //捕获类找不到异常
            System.out.println("Employee class not found");
            c.getMessage();
            return;
        }
        //无异常，直接打印输出
        System.out.println("name:" + e.name);//张三
        System.out.println("Address:" + e.address);//北京
        System.out.println("Age:" + e.age);//0，该项不可被序列化，被 transient 关键字修饰
    }
}
