package reflect;

import domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
/*
* Constructor：将构造器这种属性封装成一个类，通过该类的构造器对象可以创建该类的对象
* */
public class reflectDemo03 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class personClass = Person.class;
        //获取无参数构造器
        Constructor constructor = personClass.getConstructor();
        //通过无参数构造器创建无参数对象
        Object person = constructor.newInstance();
        System.out.println(person);
        //创建无参数对象的简便方法
        Object person1 = personClass.newInstance();
        //获取带参数构造器
        Constructor constructor1 = personClass.getConstructor(int.class, String.class, int.class, int.class);
        //有参构造器创建有参对象
        Object person2 = constructor1.newInstance(1,"张三",2,3);
        System.out.println(person2);

        //* Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
        //* Constructor<?>[] getDeclaredConstructors()
        //越权限访问构造器时需要setAccessble(true)
    }
}
