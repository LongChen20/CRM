package com.crm.Utils;

/**
 * @author LGCN
 */
public class UploadUtil {

    /**
     * 唯一文件名处理，入参文件名。
     * @return 返回加了时间戳的唯一文文件名。
     */
    public static String uniqueFileName(String pathname){
        int index = pathname.lastIndexOf(".");
        //前缀
        String prefix = pathname.substring(0, index);
        //唯一标识
        long unique = System.currentTimeMillis();
        //后缀
        String suffix = pathname.substring(index, pathname.length());
        return prefix+"-"+unique+suffix;
    }

    /**
     * 目录分离。入参文件名
     * @return
     */
    public static String pathName(String fileName){
        //获得哈希值。
        int code = fileName.hashCode();
        //得到一级目录。0xf(十六进制里面的十五以二进制表示1111) &都为1才是1.
        int path1 = code & 0xf;
        //右移4为，前面补0，
        int code2 = path1 >>> 4;
        int path2 = code2 & 0xf;
        return "/"+path1+"/"+path2;
    }

}
