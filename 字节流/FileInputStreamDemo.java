package 字节流;

import java.io.FileInputStream;

import java.io.IOException;

public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\ZZY\\Desktop\\JavaNote\\test\\a.txt");

        int len = 0;
        while((len = fis.read()) != - 1){
            System.out.println((char)len);
        }

        fis.close();
        /*read一次读取一个字节，再次去取会读取下一个字节*/

        //一次读取多个字节
        FileInputStream fis2 = new FileInputStream("C:\\Users\\ZZY\\Desktop\\JavaNote\\test\\b.txt");
        byte[] bytes = new byte[1024];
        int len2 = 0;
        while((len2 = fis2.read(bytes)) != - 1){
            System.out.println(new String(bytes,0,len2));
        }

        fis.close();

    }
}
