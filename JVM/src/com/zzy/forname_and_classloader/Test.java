package forname_and_classloader;

/**
 * 测试 forname 与 classloader 加载类的区别
 * forname 加载后还会触发类的初始化，而classloader 不会
 *
 * */
public class Test {
    public static void main(String[] args) {
        String lineName = "forname_and_classloader.Line";
        System.out.println("测试ClassLoader");
        testClassLoader(lineName);
        System.out.println("测试forname");
        testForName(lineName);
    }

    public static void testClassLoader(String lineName){
        Class line;
        /*获取了一个应用程序类加载器*/
        ClassLoader loader = ClassLoader.getSystemClassLoader();

        try {

            line = loader.loadClass(lineName);
            System.out.println("line  " + line.getName());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void testForName(String lineName){
        try {
            Class line = Class.forName(lineName);
            System.out.println("line  " + line.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
