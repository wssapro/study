package cn.ws.tools;

import java.io.*;
import java.util.Scanner;

/**
 * 分隔过大log
 *
 * @author shun
 * @date 2020-09-22 10:37
 */
public class TxtSplit {

	public static void main(String[] args) {


		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入文件路径：");
		String fileName = scanner.next();
		System.out.println("请输入截取行数：");
		int num = scanner.nextInt();
		test(fileName, num);
	}

	public static void log(FileWriter fileWriter, String s) {
		try {
			fileWriter.append(s);
			fileWriter.write("\r\n");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void close(FileWriter fileWriter) {
		try {
			fileWriter.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void test(String file, int num) {
		try {
			FileInputStream fstream = new FileInputStream(new File(file));
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			FileWriter fileWriter = new FileWriter(file + "_bak");
			String strLine;
			int count = 0;
			while ((strLine = br.readLine()) != null) {
				log(fileWriter, strLine);
				count++;
				if (count >= num) {
					break;
				}
			}
			close(fileWriter);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
