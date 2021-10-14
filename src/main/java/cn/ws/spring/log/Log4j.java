package cn.ws.spring.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * LOG配置
 *
 * @author user
 */
public class Log4j
{
	public interface NAME
	{

		Logger LOGS_RABBITMQ = LoggerFactory.getLogger("LOGS_RABBITMQ");
		Logger LOGS_ERROR = LoggerFactory.getLogger("LOGS_ERROR");
		Logger LOGS_SOUT = LoggerFactory.getLogger("LOGS_SOUT");
	}

	/**
	 * 打印堆栈信息
	 *
	 * @param e
	 */
	public static void printStackTrace(Exception e, String markCode)
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:sss");
		StackTraceElement[] stack = e.getStackTrace();
		StringBuilder result = new StringBuilder(simpleDateFormat.format(new Date()) + "---" + markCode + "\n" + e.toString() + "\n");
		for (StackTraceElement stackTraceElement : stack)
		{
			result.append(stackTraceElement.getClassName()).append(".").append(stackTraceElement.getMethodName()).append("(").append(stackTraceElement.getFileName()).append(":").append(stackTraceElement.getLineNumber()).append(")\n");
		}
		NAME.LOGS_ERROR.info(result.toString());
	}
}
