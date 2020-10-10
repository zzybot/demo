package 字节流;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

/*复制一个文件*/
public class copy {
    public static void main(String[] args) throws IOException {
        long s =  System.currentTimeMillis();

        FileInputStream fis = new FileInputStream("C:\\Users\\ZZY\\Desktop\\JavaNote\\02-Java语言进阶\\原理图\\哈希表.png");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\ZZY\\Desktop\\哈希表.png");

        byte[] bytes = new byte[409600000];
        int len = 0;
        while((len = fis.read(bytes)) != -1){
            fos.write(bytes,0,len);
        }


        fos.close();
        fis.close();

        long e =  System.currentTimeMillis();
        System.out.println("文件输出耗时" + (e-s) + "毫秒" );
    }
}
