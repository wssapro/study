package cn.ws.jdk8.List;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author shun
 * @date 2020-06-01 10:27
 */
public class Linked {

    public static void main(String[] args) {

        Map map = new HashMap();
        for (int i = 0; i < 20; i++)
        {
            map.put(i,i);
        }
        Object o = map.get(13);
        System.out.println(o.toString());
    }
}
