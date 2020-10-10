package 缓冲流;

import java.io.*;

/*字节缓冲流读写效率比基本流更高*/
public class BufferedDemo {
    public static void main(String[] args) {
        //记录开始时间
        long start = System.currentTimeMillis();
        //创建流对象
        try(
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Users\\ZZY\\Desktop\\JavaNote\\PanDownload_v2.1.3.zip"));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:\\Users\\ZZY\\Desktop\\PanDownload_v2.1.3.zip"));
        ){
         byte[] b = new byte[1024*8];
         int len = 0;
         while( (len = bis.read(b)) != -1){
             bos.write(b,0,len);
         }
        }catch(IOException e){
            e.printStackTrace();
        }
        //记录截止时间
        long end = System.currentTimeMillis();
        System.out.println("复制文件用时："+(end-start));

    }
}
