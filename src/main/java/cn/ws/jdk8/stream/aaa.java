package cn.ws.jdk8.stream;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author shun
 * @date 2021-01-26 18:20
 */
public class aaa {
	public static void main(String[] args) {
		//printUsage();
		CpuUsage cpuUsage = new CpuUsage();
		cpuUsage.get();
	}

	private static void printUsage() {
		OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();

		System.out.println(operatingSystemMXBean.getSystemLoadAverage());
		System.out.println(operatingSystemMXBean.getAvailableProcessors());




		for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
			method.setAccessible(true);
			if (method.getName().startsWith("get") && Modifier.isPublic(method.getModifiers())) {
				Object value;
				try {
					value = method.invoke(operatingSystemMXBean);
				}
				catch (Exception e) {
					value = e;
				}
				System.out.println(method.getName() + " = " + value);
			}
		}
	}





}
