package cn.ws.blazefire.log;

import cn.ws.tools.ReadLog;

import java.util.HashSet;
import java.util.List;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2021-10-08 11:49
 */
public class StatiticsLog {

    public static void main(String[] args) {

        List<String> read = ReadLog.read("C:\\Users\\Host-424\\Desktop\\a.log");

        HashSet<String> set = new HashSet<>();

        for (String s : read) {

            String[] split = s.split("-");
            System.out.println(" map.put(\""+ split[1]+"\",\""+ split[0]+"\");");
        }
        System.out.println(1);
    }
}
