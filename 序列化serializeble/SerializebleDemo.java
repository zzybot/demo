package 序列化serializeble;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializebleDemo {
    public static void main(String[] args) {
        Empolyee e = new Empolyee();
        e.name = "张三";
        e.address = "北京";
        e.age = 20;
        try{
            //获取 ObjectOutputStream 对象
            FileOutputStream fileout =  new FileOutputStream("C:\\Users\\ZZY\\Desktop\\JavaNote\\test\\employee.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            //写出对象
            out.writeObject(e);
            //关闭流
            out.close();
            fileout.close();
            System.out.println("Serializeble data is saved ");
        }catch(IOException i){
            i.printStackTrace();
        }
    }
}
