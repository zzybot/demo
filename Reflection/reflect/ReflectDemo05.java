package reflect;


import java.io.InputStream;
import java.util.Properties;

/*写一个“框架”
* 要求可以创建任意类的对象，运行该对象的任意方法
* */
public class ReflectDemo05 {
    public static void main(String[] args) throws Exception {
        //创建properties
        Properties pro = new Properties();
        //加载配置文件
        //获取class目录下的配置文件
        ClassLoader classLoader = ReflectDemo05.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("pro.properties");
        pro.load(is);

        //获取配置文件中定义的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");

        //以上步骤为了获取被测试类的类名和方法名

        //加载该类进内存
        Class cls = Class.forName(className);
        //创建对象
        Object obj = cls.newInstance();
        //获取方法对象并执行
        cls.getMethod(methodName,int.class).invoke(obj,5);

    }
}
