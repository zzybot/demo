package 缓冲流;

import java.io.*;
import java.util.HashMap;

/*练习*/
public class Test {
    public static void main(String[] args) {
        //创建map集合，保存文本数据，键为序号，值为文字
        HashMap<String,String> lineMap = new HashMap<>();

        //创建流对象
        try(
                BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ZZY\\Desktop\\JavaNote\\test\\story.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\ZZY\\Desktop\\JavaNote\\test\\out.txt"));
        ){
            //读取数据
            String line = null;
            while((line = br.readLine()) != null){
                //解析文本
                String[] str = line.split("\\.");
                //保存到集合
                lineMap.put(str[0],str[1]);
            }

            for (String key: lineMap.keySet())
            {
                String value = lineMap.get(key);
                bw.write(key + "." + value);
                bw.newLine();
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
