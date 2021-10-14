package cn.ws.tools;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author : Host-424
 * @date Date : 2021-09-06 18:14
 */
public class ReadLog {

    public static List<String> read(String file) {

        List<String> list = new ArrayList<>();
        try {
            FileInputStream fstream = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                list.add(strLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}
