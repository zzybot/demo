package 缓冲流;

import java.io.*;

/*字符缓冲流，两个专用方法*/
public class BufferedDemo2 {
    public static void main(String[] args) throws IOException {
        //创建流对象
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ZZY\\Desktop\\JavaNote\\test\\f.txt"));

        //定义字符串保存读取的一行文字
        String line = null;
        while((line = br.readLine()) !=null){//一次读取一行
            System.out.println(line);
            System.out.println("-------------");
        }

        br.close();

        //创建流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\ZZY\\Desktop\\JavaNote\\test\\f.txt",true));
        bw.write("黑马");
        //换行
        bw.newLine();
        bw.write("程序");
        bw.newLine();
        bw.write("员");

        bw.close();
    }
}
