package 字符流;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
        long s = System.currentTimeMillis();
        FileReader fr = new FileReader("C:\\Users\\ZZY\\Desktop\\JavaNote\\test\\c.txt");
        int len = 0;
        while((len = fr.read()) != -1){
            System.out.print((char) len);
        }
        long e = System.currentTimeMillis();
        System.out.println("用时：" + (e - s));
        fr.close();


        //
        long s1 = System.currentTimeMillis();
        FileReader fr1 = new FileReader("C:\\Users\\ZZY\\Desktop\\JavaNote\\test\\c.txt");
        int len1 = 0;
        char[] cs = new char[1024];
        while ((len1 = fr1.read(cs)) != -1) {
            System.out.print(new String(cs,0,len1));
        }
        long e1 = System.currentTimeMillis();

        System.out.println("用时：" + (e1 - s1));
        fr.close();
    }
}
