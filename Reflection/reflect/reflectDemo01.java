package reflect;

import domain.Person;

public class reflectDemo01 {


    public static void main(String[] args) throws Exception {
        //三种获取class对象的方式
        Person person = new Person();
        Class cls1 = person.getClass();//对象.getclass
        Class cls2 = Person.class;//类名.class
        Class cls = Class.forName("domain.Person");//静态方法forname，参数是完整类名

        System.out.println(cls == cls1);
        System.out.println(cls == cls2);


    }
}
