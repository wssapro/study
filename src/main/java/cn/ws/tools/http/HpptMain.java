package cn.ws.tools.http;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 *
 * </p>
 *
 * @author shun
 * @date 2020-03-27 14:52
 */
public class HpptMain {

    public static void main(String[] args) {
        String str = "@@opc@@wq@@-1#2#3";
        String regEx = "@@opc@@wq@@-[\\s\\S]*#[\\s\\S]*#[\\s\\S]*";
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regEx);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        // 字符串是否与正则表达式相匹配
        boolean rs = matcher.matches();
        System.out.println(rs);



        String[] split = str.split("#");
        System.out.println(split[1]);
    }
}
