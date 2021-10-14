package cn.ws.jdk8.jvm;

import java.io.*;

/**
 * <p>
 *
 * </p>
 *
 * @author shun
 * @date 2020-05-14 16:28
 */
public class MyClassLoader extends ClassLoader {
    private String root;

    public MyClassLoader(String root) {
        this.root = root;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = loadClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }

    private byte[] loadClassData(String className) {
        String fileName = root + File.separatorChar
                + className.replace('.', File.separatorChar) + ".class";
        try {
            InputStream ins = new FileInputStream(fileName);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            int length = 0;
            while ((length = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, length);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) throws Exception {
        Class<?> aClass = new MyClassLoader("D:\\idea\\jdk8").loadClass("com.jdk8.jvm.Student");
        Student student = (Student) aClass.newInstance();
        student.setName("aaaaa");
        System.out.println(student.getName());
    }
}
