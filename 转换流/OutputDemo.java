package 转换流;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputDemo {
    public static void main(String[] args) throws IOException {
        //
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("C:\\Users\\ZZY\\Desktop\\JavaNote\\test\\output.txt"));
        //
        osw.write("你好");
        osw.close();

        //
        OutputStreamWriter osw2 = new OutputStreamWriter(new FileOutputStream("C:\\Users\\ZZY\\Desktop\\JavaNote\\test\\output2.txt"),"GBK");
        osw2.write("你好");
        osw2.close();
    }
}
