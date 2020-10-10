package reflect;

import domain.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/*
* Method：将类中的方法封装为一个类，
* */
public class relectDemo04 {
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;
        //获取public修饰的所有方法成员方法
        Method[] methods = personClass.getMethods();//由父类继承来的public方法也会被获取到
        for (Method method : methods
        ) {
            System.out.println(method);//打印出该类以及该类的父类的public方法
            String name = method.getName();//获取方法名
            System.out.println(name);
        }
        //获取public修饰的指定方法，指定名称和参数
        Method eat_method = personClass.getMethod("sleep", int.class);
        //执行方法
        Person p = new Person();
        eat_method.invoke(p,5);//执行方法invoke();
        //* Method[] getDeclaredMethods()
        //* Method getDeclaredMethod(String name, 类<?>... parameterTypes)
        //如果忽略修饰符运行方法，则必须进行暴力反射
        Method[] methods1 = personClass.getDeclaredMethods();
        for (Method method : methods1
        ) {
            method.setAccessible(true);
            //.......
        }


    }
}
