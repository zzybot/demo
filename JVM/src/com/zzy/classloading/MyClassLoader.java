package JVM;


/**
 * ClassLoader 中双亲委派模型的实现
 * */
public class MyClassLoader {

    /** 略 */
    
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        synchronized (getClassLoadingLock(name)) {
            // 首先，从缓存中获得 name 对应的类
            Class<?> c = findLoadedClass(name);
            if (c == null) { // 获得不到
                try {
                    // 其次，如果父类非空，使用它去加载类
                    if (parent != null) {
                        c = parent.loadClass(name, false);
                        // 其次，如果父类为空，使用 Bootstrap 去加载类
                    } else {
                        c = findBootstrapClassOrNull(name);
                    }
                } catch (ClassNotFoundException e) {
                }

                if (c == null) { // 还是加载不到
                    // 最差，使用自己去加载类
                    c = findClass(name);
                }
            }
            // 如果要解析类，则进行解析
            if (resolve) {
                resolveClass(c);
            }
            return c;
        }
    }
}
