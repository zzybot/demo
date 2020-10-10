package 字符流;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("C:\\Users\\ZZY\\Desktop\\JavaNote\\test\\d.txt");
        fw.write(97);//内存 → 缓冲区 → 硬盘 = 字符串 → 字节

        fw.close();
       /* fw.close();//fw.flush();刷新缓冲区*/


        FileWriter fw1 = new FileWriter("C:\\Users\\ZZY\\Desktop\\JavaNote\\test\\d.txt",true);

        char[] ch = {'a','b','c','d'};
        fw1.write(ch);
        fw1.write("\r\n");
        fw1.close();

        FileWriter fw2 = new FileWriter("C:\\Users\\ZZY\\Desktop\\JavaNote\\test\\d.txt",true);
        fw2.write("黑马程序员"+"\r\n");

        fw2.write("黑马程序员",2,3);
        fw2.close();




    }
}
