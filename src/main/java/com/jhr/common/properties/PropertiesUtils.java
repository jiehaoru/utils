package com.jhr.common.properties;

import com.jhr.common.exception.FileIOException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * <br>
 * 标题：properties 工具类
 * 描述：
 *
 * @author jhr
 * @create 2019/11/27 17:04
 */
public class PropertiesUtils {
    public PropertiesUtils() {
    }

    /**
     *
     * @param dirPath properties文件的父层路径
     * @param fileName properties文件名
     * @param fileContent properties文件内容
     * @throws IOException
     */
    public static void creatProperties(String dirPath, String fileName, Map<String,String> fileContent) throws Exception {

        Properties properties = new Properties();
        if(fileContent.size()>0){
            for (Map.Entry<String, String> entry : fileContent.entrySet()) {
                properties.setProperty(entry.getKey(),entry.getValue());
            }
        }
        String defaultFile=dirPath+"/"+fileName;
        File file = null;
        FileWriter writer = null;
        try {
            file = new File(defaultFile);
            file.createNewFile();
            writer = new FileWriter(file);
            properties.store(writer,"注释");
        }catch (Exception e){
            e.printStackTrace();
            throw new FileIOException("creatProperties() 方法文件创建写入异常");
        }finally {
            if(writer !=null){
                try {
                    writer.close();
                }catch (Exception e){
                    e.printStackTrace();
                    throw new FileIOException("FileWriter 文件写入的close()关闭报异常");
                }
            }
        }




    }

    /**
     *  配置文件中追加属性
     * @param dirPath properties文件的父层路径
     * @param fileName properties文件名
     * @param fileContent properties文件内容
     * @throws IOException
     */
    public static void addPropertiesInfo(String dirPath, String fileName, Map<String,String> fileContent) throws Exception {

        Properties properties = new Properties();
        String fileURL=dirPath+"/"+fileName;
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader(fileURL);//先读取原文件信息
            if(fileContent.size()>0){
                for (Map.Entry<String, String> entry : fileContent.entrySet()) {
                    properties.setProperty(entry.getKey(),entry.getValue());
                }
            }
            fileWriter =  new FileWriter(fileURL);
            properties.store(fileWriter,"注释");;
        }catch (Exception e){
            throw new FileIOException("addPropertiesInfo() 方法,文件读取和写入过程异常");
        }finally {
            if(fileWriter !=null){
                try {
                    fileWriter.close();
                }catch (Exception e){
                    e.printStackTrace();
                    throw new FileIOException("FileWriter 文件写入的close()关闭报异常");
                }
            }
            if(fileReader !=null){
                try {
                    fileReader.close();
                }catch (Exception e){
                    e.printStackTrace();
                    throw new FileIOException("FileReader 文件读取的close()关闭报异常");
                }
            }
        }
    }

}
