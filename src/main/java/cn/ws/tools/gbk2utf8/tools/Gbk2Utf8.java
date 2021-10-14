package cn.ws.tools.gbk2utf8.tools;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * convert GBK encoding to UTF-8
 * 
 */
public class Gbk2Utf8 {

	public static void main(String[] args) throws Exception {


		String srcGbkPath = "D:\\Blazefire\\ADTraffic\\PT_SMTK\\DYBehavior\\src\\com";
		String dstUtf8Path = "C:\\Users\\Host-424\\Desktop\\a";
		String extension = "java";
		if (args.length > 2) {
			extension = args[2];
		}
		boolean isJava = "java".equalsIgnoreCase(extension);

		Collection<File> gbkFiles = FileUtils.listFiles(new File(srcGbkPath), new String[] { extension }, true);

		int count = 0;
		for (File gbkFile : gbkFiles) {
			if (isJava && gbkFile.getName().endsWith("__jsp.java")) {
				continue;
			}

			AtomicBoolean isGBK = new AtomicBoolean();
			String srcEncoding = encodingName(gbkFile, isGBK);

			if (!isGBK.get()) { // is NOT GBK/GB-2312/GB18030
				System.out.println("skip " + srcEncoding + " on " + gbkFile.getName());
				continue;
			}
			String subPathFile = gbkFile.getAbsolutePath().substring(srcGbkPath.length());
			String utf8FileName = dstUtf8Path + subPathFile;
			System.out.println("converting NO." + (++count) + " " + srcEncoding + " on " + subPathFile.substring(1));

			FileUtils.writeLines(new File(utf8FileName), "UTF-8", FileUtils.readLines(gbkFile, "GBK")); // GBK
		}
		System.out.println("Finish: " + count + " files converted from gbk to utf8");
	}

	private static EncodingDetect detect = new EncodingDetect();

	/**
	 * @param isGBK
	 *            output param indicating whether the file is GBK or NOT
	 */
	private static String encodingName(File file, AtomicBoolean isGBK) {
		int encodingNumber = detect.detectEncoding(file);
		// may return GBK > GB-2312 > GB18030
		String name = EncodingDetect.javaname[encodingNumber];
		isGBK.set(name.startsWith("GB"));
		return name;
	}
}
