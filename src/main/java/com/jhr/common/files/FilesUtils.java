package com.jhr.common.files;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * <br>
 * 标题：关于文件
 * 描述：
 *
 * @author jhr
 * @create 2019/11/27 17:32
 */
public class FilesUtils {
    public FilesUtils() {
    }

    /**
     * 判断某类型的 文件在某路径下是否存在.
     * 存在即返回文件名和路径的集合
     * @param path 扫描的路径
     * @param fileType 扫描的文件类型
     * @param fileMap 返回的Map<文件名,路径>
     * @return
     * @throws IOException
     */
    public static Map<String,String> isExistFile(String path, String fileType, Map<String,String> fileMap) throws IOException {
        if(fileType==null || fileType==""){
            fileType="json";
        }
        File file = new File(path);
        String canonicalPath = file.getCanonicalPath();
        File filelist[] = file.listFiles();

        if (null!=filelist){
            for (File subFile : filelist) {
                if (subFile.isDirectory()) {       //是文件夹则递归寻找，后缀为json文件则输出名字
                    isExistFile(subFile.getAbsolutePath(), fileType,fileMap);
                }
                else if(subFile.isFile() && subFile.getName().endsWith(fileType)) { //是文件则 ,查文件结尾处是否为json
                    String fileName=subFile.getName().substring(0,subFile.getName().lastIndexOf("."));;
                    fileMap.put(fileName,canonicalPath);
                    continue;
                }
            }
        }
        return fileMap;
    }
}
