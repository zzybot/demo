package 转换流;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {
    public static void main(String[] args) throws IOException {
        //定义文件路径，文件为gbk编码
        String fileName = "C:\\Users\\ZZY\\Desktop\\JavaNote\\test\\GBK.txt";
        //UTF-8
        InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName));
        //GBK
        InputStreamReader isr2 = new InputStreamReader(new FileInputStream(fileName),"GBK");
        //
        int read;
        //使用UTF-8读取，大家好
        while((read = isr.read())!= -1){
            System.out.println((char)read);
        }
        System.out.print("这是默认字符集");
        System.out.println("");
        isr.close();
        //使用GBK读取，乱码
        while ((read = isr2.read()) != -1){
            System.out.print((char)read);
        }
        System.out.println("这是指定字符集");
        isr2.close();
    }
}
