package com.coinisi.common.core.util;

public class PathUtil {
    public  static  String interception(String path){
        String[] paths = path.split("/");
        StringBuffer pathString = new StringBuffer();
        for (int i=2;i<paths.length;i++){
               pathString.append("/"+paths[i]);
        }
        return pathString.toString();
    }

}
