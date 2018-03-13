package com.junli.custom;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 自定义类加载器
 * @author lijun
 * @since 2018-03-12 17:59
 */
public class LIClassLoader extends ClassLoader{

    private File classPathFile;

    public LIClassLoader(){
        String classPath = LIClassLoader.class.getResource("").getPath();
        this.classPathFile = new File(classPath);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        {

            String className = LIClassLoader.class.getPackage().getName() + "." + name;

            if(classPathFile != null){
                File classFile = new File(classPathFile,name.replaceAll("\\.","/") + ".class");
                if(classFile.exists()){
                    FileInputStream in = null;
                    ByteArrayOutputStream out = null;

                    try{
                        in = new FileInputStream(classFile);
                        out = new ByteArrayOutputStream();
                        byte [] buff = new byte[1024];
                        int len;
                        while ((len = in.read(buff)) != -1){
                            out.write(buff,0,len);
                        }
                        return  defineClass(className,out.toByteArray(),0,out.size());
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        if(null != in){
                            try {
                                in.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        if(out != null){
                            try {
                                out.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

            }

            return null;

        }
    }

}
