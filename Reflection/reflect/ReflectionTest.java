package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**  反射 demo，打印一个类的所有信息*/
public class ReflectionTest {
    public static void main(String[] args) {
        //从命令行或用户输入中读取类名
        String name;
        if (args.length > 0) {
            name = args[0];
        }else{
            Scanner scanner = new Scanner(System.in);
            System.out.println("输入类名称（e.g.java.util.Date）:");
            name = scanner.next();
        }

        //打印类名和直接父类名
        try {
            Class cl = Class.forName(name);
            Class supercl = cl.getSuperclass();
            String modifiers = Modifier.toString(cl.getModifiers());
            if (modifiers.length()>0){
                System.out.print(modifiers + " ");
            }
            System.out.print("class" + name);
            if (supercl != null && supercl != Object.class){
                System.out.print("extends" + supercl.getName());
            }

            System.out.print("\n{\n");
            printConstructors(cl);
            System.out.println();
            printMethod(cl);
            System.out.println();
            printFields(cl);
            System.out.println("}");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    /**
     *
     * */

    /**
     * 打印构造器信息
     */

    public static void printConstructors(Class cl) {
        //返回Class对象所描述的类的所有构造器（包括私有的）
        Constructor[] constructors = cl.getDeclaredConstructors();

        for (Constructor c : constructors) {
            //获取构造器方法名，返回一个字符串
            String name = c.getName();
            System.out.print("   ");
            //getModifiers返回一个整数，用来描述public、static等修饰符的使用情况,Modifier类重写了toString方法，实现了整数到字符串（修饰符名字）的转换。
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) {//可能有修饰符，也可能没有
                System.out.print(modifiers + " ");
            }
            System.out.print(name + "(");

            //打印参数类型
            //返回一个数组，里面存放的是描述参数的类型的Class对象
            Class[] paramTypes = c.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) {
                    System.out.println(",");
                    System.out.println(paramTypes[i].getName());
                }
                System.out.println(");");
            }
        }
    }

    /**
     * 打印全部类中的方法信息
     */

    public static void printMethod(Class cl) {
        //返回一个数组，数组中存放全部Method对象
        Method[] methods = cl.getDeclaredMethods();

        for (Method m : methods) {
            //返回一个描述方法返回值类型的Class对象
            Class returnType = m.getReturnType();
            String name = returnType.getName();

            System.out.print("   ");
            //打印修饰符、返回值、方法名
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print(returnType.getName() + " " + name + "(");
            //打印参数类型
            Class[] paramTypes = m.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) {
                    System.out.print(",");
                    System.out.print(paramTypes[i].getName());
                }
                System.out.println(");");
            }
        }
    }

    /**
     * 打印该类所有域信息
     */
    public static void printFields(Class cl) {
        Field[] fields = cl.getDeclaredFields();
        for (Field f : fields
        ) {
            Class type = f.getType();
            String name = f.getName();
            System.out.print("   ");
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length() > 0) {
                System.out.println(modifiers + " ");
            }
            System.out.println(type.getName() + " " + name + ";");
        }
    }
}
