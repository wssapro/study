package cn.ws.jdk8.zip.zip;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * <p>
 *
 * </p>
 *
 * @author shun
 * @date 2020-05-28 11:42
 */
public class test {
    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Host-0\\Desktop\\upload\\2020_05_27_1.zip");
        ZipUtil.toZip("C:\\Users\\Host-0\\Desktop\\upload\\2020_05_27_1",outputStream,true);
    }
}
