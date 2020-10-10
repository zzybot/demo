package 字节流;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/*字节输出流*/
public class FileOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        //两种构造
        //1.File对象构造
        File file = new File("C:\\Users\\ZZY\\Desktop\\JavaNote\\test\\a.txt");
        FileOutputStream fos = new FileOutputStream(file);

        //2.使用文件名创建流对象
        FileOutputStream fos2 = new FileOutputStream("C:\\Users\\ZZY\\Desktop\\JavaNote\\test\\b.txt");

        //写出字节数据
        fos2.write(97);
        fos2.write(98);
        fos2.write(99);
        fos2.write("\r\n".getBytes());

        //关闭资源
        fos2.close();

        //写出字节数组
        FileOutputStream fos3 = new FileOutputStream("C:\\Users\\ZZY\\Desktop\\JavaNote\\test\\b.txt",true);//追加续写
        byte[] b = "黑马程序员".getBytes();
        fos3.write(b);
        fos3.write("\r\n".getBytes());
        fos3.close();

        //写出指定长度字节数组
        FileOutputStream fos4 = new FileOutputStream("C:\\Users\\ZZY\\Desktop\\JavaNote\\test\\b.txt",true);
        byte[] b2 = "abcde".getBytes();
        fos4.write(b2,2,2);
        fos4.write("\r\n".getBytes());
        fos4.close();

        //写出换行
        FileOutputStream fos5 = new FileOutputStream("C:\\Users\\ZZY\\Desktop\\JavaNote\\test\\b.txt",true);

        byte[] b3 = {97,98,99,100,101};
        for (int i = 0; i < b3.length; i++) {
            fos5.write(b3[i]);
            fos5.write("\r\n".getBytes());
        }

        fos5.close();





    }
}
