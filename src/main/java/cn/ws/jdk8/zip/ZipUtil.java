package cn.ws.jdk8.zip;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * <p>
 *
 * </p>
 *
 * @author shun
 * @date 2020-04-29 18:00
 */
public class ZipUtil {
    public static void main(String[] args) {
        try {
            unZipFiles("C:\\Users\\Host-0\\Desktop\\1.zip","C:\\Users\\Host-0\\Desktop");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void unZipFiles(String zipPath, String descDir) throws IOException {
        long start = System.currentTimeMillis();
        try{
            File zipFile = new File(zipPath);
            System.err.println(zipFile.getName());
            if(!zipFile.exists()){
                throw new IOException("需解压文件不存在.");
            }
            File pathFile = new File(descDir);
            if (!pathFile.exists()) {
                pathFile.mkdirs();
            }
            String absolutePath = pathFile.getAbsolutePath();
            System.out.println(absolutePath);
            ZipFile zip = new ZipFile(zipFile, Charset.forName("GBK"));
            for (Enumeration entries = zip.entries(); entries.hasMoreElements();) {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                String zipEntryName = entry.getName();

                InputStream in = zip.getInputStream(entry);
                String outPath = (descDir + File.separator + zipEntryName).replaceAll("\\*", "/");
                // 判断路径是否存在,不存在则创建文件路径
                File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));
                if (!file.exists()) {
                    file.mkdirs();
                }
                // 判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
                if (new File(outPath).isDirectory()) {
                    continue;
                }
                // 输出文件路径信息
                OutputStream out = new FileOutputStream(outPath);
                byte[] buf1 = new byte[1024];
                int len;
                while ((len = in.read(buf1)) > 0) {
                    out.write(buf1, 0, len);
                }
                in.close();
                out.close();
            }
        }catch(Exception e){
            throw new IOException(e);
        }
    }
}
