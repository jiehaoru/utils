package com.jhr.common.url;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;

import java.net.URL;

/**
 * <br>
 * 标题：关于路径
 * 描述：
 *
 * @author jhr
 * @create 2019/11/27 17:42
 */
public class URLUtils {
    public URLUtils() {
    }

    /**
     * 获取 当前该类 编译后的所在绝对路径
     * target目录下
     *
     * @return /D:/IdeaProjects/dubbo-sentinel/dubbo-sentinel-admin/target/classes/
     */
//    public static String gainTargetAbsolutePath(T className) {
//        ClassLoader classLoader = T.class.getClassLoader();
//        URL resource = classLoader.getResource("");
//        System.out.println(resource);
//        String path = resource.getPath();
//        return path;
//    }


    /**
     * 获取resources的绝对路径,
     * 并将路径格式转换成linux的
     *
     * @return D:/IdeaProjects/dubbo-sentinel/dubbo-sentinel-admin/src/main/resources
     */
    public static String gainResourcesAbsolutePath() {
        String nowUrl = System.getProperty("user.dir");
        String s;
        String os = System.getProperty("os.name");
        if (os.contains("Windows")) {
            String newURL = nowUrl.replaceAll("\\\\", "/");//window的路径格式换成linux的
            s = StringUtils.substringBeforeLast(newURL, "/");
        } else {
            s = StringUtils.substringBeforeLast(nowUrl, "/");
        }
        return s;
    }
}
