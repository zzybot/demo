package com.zzy.classloading;

import java.io.IOException;
import java.io.InputStream;

/**
 * 测试不同类加载器对 instanceof 结果的影响，验证类与其类加载器一同确定在虚拟机中的唯一性
 *
 * @author ZZY
 * */
public class ClassLoaderTest {
    public static void main(String[] args) throws Exception {

        /*定义一个自己的类加载器，用于与系统类加载器作对比*/
        ClassLoader myloader = new ClassLoader() {
            /*loadClass：加载类并返回类的实例*/
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    /*获取 class文件名 */
                    String fileName = name.substring(name.lastIndexOf("." ) + 1) + ".class";

                    InputStream is = getClass().getResourceAsStream(fileName);

                    if (is == null){
                        return super.loadClass(name);
                    }

                    /*读取 class 文件，is.available() 返回数据流中可读取的字节数*/
                    byte[] b = new byte[is.available()];
                    is.read(b);

                    /*把字节数组中的内容转换成 java 类的实例
                    * String：类全限定名
                    * byte[]：要转换的数组
                    * off：从指定索引位置开始
                    * len：转换长度*/
                    return defineClass(name,b,0,b.length);

                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = myloader.loadClass("com.zzy.classloading.ClassLoaderTest").newInstance();

        System.out.println(obj.getClass());
        System.out.println(obj instanceof com.zzy.classloading.ClassLoaderTest);

        /**
         * 输出结果：class com.zzy.classloading.ClassLoaderTest
         *         false
         * 虽然 getClass();得到的结果相同（属于同一个class 文件），但 instanceof 的结果是 false
         * */
    }
}
