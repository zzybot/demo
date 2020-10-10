package reflect;

import domain.Person;

import java.lang.reflect.Field;
/*
* Field类相关，Field：将成员变量这种属性封装成一个类
* */
public class reflectDemo02 {
    public static void main(String[] args) throws Exception {
        Class personcls = Person.class;
        Field[] fields = personcls.getFields();//获取所有public修饰的成员变量
        for (Field field : fields
        ) {
            System.out.println(field);//遍历输出成员变量
        }

        Field length = personcls.getField("length");//获取被public修饰的指定成员变量，参数为成员变量名的字符串形式
        System.out.println(length.get(new Person()));//获取成员变量的值

        System.out.println("=================");

        Field[] fields1 = personcls.getDeclaredFields();//不考虑修饰符，获取所有成员变量
        for (Field field : fields1
        ) {
            System.out.println(field);
        }

        Field weight = personcls.getDeclaredField("weight");//不考虑修饰符，获取指定成员变量
        //不可以直接对权限外的成员变量直接访问
        //忽略访问修饰符的安全检查
        Person p = new Person();
        weight.setAccessible(true);//暴力反射
        weight.set(p,60);//设置成员变量的值，要对该成员变量进行访问
        System.out.println(weight.get(p));
        System.out.println("=================");


    }
}
