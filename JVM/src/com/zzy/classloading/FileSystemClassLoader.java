package com.zzy.classloading;

import java.io.*;
/**
 * 文件系统类加载器，可以从指定系统路径中寻找 class 文件加载
 * @author ZZY
 * */
public class FileSystemClassLoader extends ClassLoader {

    /**可以读取的类库所在路径*/
    private String rootDir;

    public FileSystemClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = getClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException(name);
        } else {
            return defineClass(name,classData,0,classData.length);
        }
    }

    private byte[] getClassData(String className) {
        String path = classNameToPath(className);

        try {
            InputStream is = new FileInputStream(path);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int byteNumRead = 0;
            /*将输入流中的二进制字节读入 buffer，再写出到字节数组输出流*/
            while ((byteNumRead = is.read(buffer)) != -1) {
                baos.write(buffer, 0, byteNumRead);
            }

            return baos.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private String classNameToPath(String className) {
        /*类库所在路径\com\zzy\xxx.class，这里获取的是 class文件在系统中的路径
          File.separatorChar：路径分隔符，windows中就是‘\’ */
        return rootDir + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
    }
}
