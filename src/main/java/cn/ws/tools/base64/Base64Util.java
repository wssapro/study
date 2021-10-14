package cn.ws.tools.base64;

import cn.ws.tools.ReadLog;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2021-09-29 16:20
 */
public class Base64Util {

    private static final int BASE64_FLAG = AndroidBase64.NO_WRAP | AndroidBase64.NO_PADDING | AndroidBase64.URL_SAFE;


    public static void main(String[] args) {


        List<String> read = ReadLog.read("C:\\Users\\Host-424\\Desktop\\a.txt");
        for (String s : read) {

            JSONObject jsonObject = JSON.parseObject(s);
            String me = jsonObject.getString("me");
            byte[] decode = AndroidBase64.decode(me, BASE64_FLAG);
            String result = new String(decode);
            if(result.contains("7351160734")){
                System.out.println(jsonObject.getString("android_id"));
            }
        }




    }
}
