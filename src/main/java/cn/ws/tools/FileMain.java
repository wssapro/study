package cn.ws.tools;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * <p>
 *
 * </p>
 *
 * @author shun
 * @date 2020-03-27 16:28
 */
public class FileMain {
    //    public static void main(String[] args) {
//        String up = "D:\\DDT_CACHE\\book\\";
//        String down = "D:\\DDT_CACHE\\a\\";
//        for (int i = 1; i < 1110; i++) {
//            try {
//                // 打开输入流
//                FileInputStream fis = new FileInputStream(up+i+"\\cover.jpg");
//                // 打开输出流
//                FileOutputStream fos = new FileOutputStream(down+"\\"+i+".jpg");
//
//                // 读取和写入信息
//                int len = 0;
//                while ((len = fis.read()) != -1) {
//                    fos.write(len);
//                }
//
//                // 关闭流  先开后关  后开先关
//                fos.close(); // 后开先关
//                fis.close(); // 先开后关
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        float alpha = 1.0f;
        String sourceUrl = "https://qcdn.zhangzhongyun.com/covers/153288701273156635.jpg";
        String waterUrl = "https://pldkzkm.wdbaodi.com/novel/category/13.png";
        String targetImg = "D:\\DDT_CACHE\\b\\sasss.jpg";
        try {
            URL url = new URL(sourceUrl);
            Image image = ImageIO.read(url);
            int width = 225;
            int height = 300;
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufferedImage.createGraphics();
            g.drawImage(image, 0, 0, width, height, null);

            Image waterImage = ImageIO.read(new URL(waterUrl));    // 水印文件
            int width_1 = waterImage.getWidth(null);
            int height_1 = waterImage.getHeight(null);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));

            int widthDiff = width - width_1;
            int heightDiff = height - height_1;
            if(x < 0){
                x = widthDiff / 2;
            }else if(x > widthDiff){
                x = widthDiff;
            }
            if(y < 0){
                y = heightDiff / 2;
            }else if(y > heightDiff){
                y = heightDiff;
            }
            g.drawImage(waterImage, x, y, width_1, height_1, null); // 水印文件结束
            g.dispose();

            File file = new File(targetImg);
            if(!file.exists()){
                file.mkdirs();
            }
            ImageIO.write(bufferedImage, "jpg", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
