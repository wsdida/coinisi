package com.coinisi.common.core.util;
import com.google.gson.Gson;
import java.util.Map;



/**
 * 1.json string 转换为 map
 * 2.json string 转换为 对象
 * @author zhangtengda
 *
 */
public class JsonUtils {

    /**
     * json string 转换为 map 对象
     * @param jsonString
     * @return Map<String,Object>
     */
    public static Map<String,Object> stringToMap(String jsonString){
        Gson g = new Gson();
        return g.fromJson(jsonString,Map.class);
    }


}
