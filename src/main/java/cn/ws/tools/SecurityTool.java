package cn.ws.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密类
 */
public class SecurityTool
{
    private byte[] key1 = null;
    private byte[] key2 = null;

    public SecurityTool()
    {
        setKey("whatdingyuead", "iamsorryppdin");
    }

    /**
     * 构造方法
     */
    public SecurityTool(String strKey1, String strKey2)
    {
        setKey(strKey1, strKey2);
    }

    public static String md5(String string)
    {
        byte[] hash;
        try
        {
            hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        }
        catch (UnsupportedEncodingException e)
        {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e);
        }

        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash)
        {
            if ((b & 0xFF) < 0x10)
            {
                hex.append("0");
            }
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString();
    }

    private static final char HEX_DIGITS[] = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
    };

    public static String toHexString(byte[] b)
    {
        StringBuilder sb = new StringBuilder(b.length * 2);
        for (int i = 0; i < b.length; i++)
        {
            sb.append(HEX_DIGITS[(b[i] & 0xf0) >>> 4]);
            sb.append(HEX_DIGITS[b[i] & 0x0f]);
        }
        return sb.toString();
    }

    public static String md5File(String filename)
    {
        return md5(new File(filename));
    }

    public static String md5(File file)
    {
        InputStream fis;
        byte[] buffer = new byte[1024];
        int numRead = 0;
        MessageDigest md5;
        try
        {
            fis = new FileInputStream(file);
            md5 = MessageDigest.getInstance("MD5");
            while ((numRead = fis.read(buffer)) > 0)
            {
                md5.update(buffer, 0, numRead);
            }
            fis.close();
            return toHexString(md5.digest());
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public static String getSHA(String val)
    {
        MessageDigest md5;
        try
        {
            md5 = MessageDigest.getInstance("SHA-1");
            md5.update(val.getBytes());
            byte[] m = md5.digest();// 加密
            return byte2hex(m);
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }

        return "";
    }

    public static String byte2hex(byte[] b)
    {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++)
        {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1)
            {
                hs = hs + "0" + stmp;
            }
            else
            {
                hs = hs + stmp;
            }
        }
        return hs;
    }

    /**
     * 根据参数生成 KEY
     *
     * @param strKey1 密钥1
     * @param strKey2 密钥2
     */
    private void setKey(String strKey1, String strKey2)
    {
        key1 = strKey1.getBytes();
        key2 = strKey2.getBytes();
    }

    /**
     * 加密数据信息
     *
     * @param context 待加密字节流
     * @return 加密字节流
     */
    public byte[] encryption(byte[] context)
    {
        int len = key1.length;
        if (context == null)
        {
            return null;
        }
        byte[] contextEncryption = new byte[context.length];

        for (int i = 0; i < context.length; i++)
        {
            contextEncryption[i] = (byte) (context[i] ^ key1[i % len]);
        }

        len = key2.length;

        for (int i = 0; i < context.length; i++)
        {
            contextEncryption[i] = (byte) (contextEncryption[i] ^ key2[i % len]);
        }

        return contextEncryption;
    }



    /**
     * 获取十六进制值的方法
     *
     * @param b 字节信息
     * @return
     */
    public int getHexValue(byte b)
    {
        if (b >= '0' && b <= '9')
        {
            return (b - '0');
        }

        return (b - 'A') + 10;
    }

    /**
     * 解密数据信息
     *
     * @param context 待解密字节流
     * @return 解密字节流
     */
    public byte[] decryption(byte[] context)
    {
        int len = key2.length;
        if (context == null)
        {
            return null;
        }
        byte[] contextEncryption = new byte[context.length];

        for (int i = 0; i < context.length; i++)
        {
            contextEncryption[i] = (byte) (context[i] ^ key2[i % len]);
        }

        len = key1.length;

        for (int i = 0; i < context.length; i++)
        {
            contextEncryption[i] = (byte) (contextEncryption[i] ^ key1[i % len]);
        }

        return contextEncryption;
    }
}
