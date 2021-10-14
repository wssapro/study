package cn.ws.jdk8.stream;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;

import java.text.DecimalFormat;

public class test {

	public static void main(String[] args) throws InterruptedException {

			SystemInfo systemInfo = new SystemInfo();
			CentralProcessor processor = systemInfo.getHardware().getProcessor();
			long[] prevTicks = processor.getSystemCpuLoadTicks();
			long[] ticks = processor.getSystemCpuLoadTicks();
			long nice = ticks[CentralProcessor.TickType.NICE.getIndex()] - prevTicks[CentralProcessor.TickType.NICE.getIndex()];
			long irq = ticks[CentralProcessor.TickType.IRQ.getIndex()] - prevTicks[CentralProcessor.TickType.IRQ.getIndex()];
			long softirq = ticks[CentralProcessor.TickType.SOFTIRQ.getIndex()] - prevTicks[CentralProcessor.TickType.SOFTIRQ.getIndex()];
			long steal = ticks[CentralProcessor.TickType.STEAL.getIndex()] - prevTicks[CentralProcessor.TickType.STEAL.getIndex()];
			long cSys = ticks[CentralProcessor.TickType.SYSTEM.getIndex()] - prevTicks[CentralProcessor.TickType.SYSTEM.getIndex()];
			long user = ticks[CentralProcessor.TickType.USER.getIndex()] - prevTicks[CentralProcessor.TickType.USER.getIndex()];
			long iowait = ticks[CentralProcessor.TickType.IOWAIT.getIndex()] - prevTicks[CentralProcessor.TickType.IOWAIT.getIndex()];
			long idle = ticks[CentralProcessor.TickType.IDLE.getIndex()] - prevTicks[CentralProcessor.TickType.IDLE.getIndex()];
			long totalCpu = user + nice + cSys + idle + iowait + irq + softirq + steal;


			double v = 1.0 - (idle * 1.0 / totalCpu);
		String format = new DecimalFormat("#.##").format(1.0 - (idle * 1.0 / totalCpu));
		double a = Double.valueOf(format);
		System.out.println("CPU总数 = {" + processor.getLogicalProcessorCount() + "},CPU利用率 ={"
				+ new DecimalFormat("#.##%").format(1.0 - (idle * 1.0 / totalCpu)) + "}");

		GlobalMemory memory = systemInfo.getHardware().getMemory();
		long totalByte = memory.getTotal();
		long acaliableByte = memory.getAvailable();

		long totalByte1 = totalByte;
		double v1 = (totalByte - acaliableByte) * 1.0 / totalByte1;
		System.out.println("内存大小 = {"+formatByte(totalByte)+"},内存使用率 ={"
						+new DecimalFormat("#.##%").format((totalByte-acaliableByte)*1.0/totalByte)+"}");


	}


	public static String formatByte(long byteNumber){
		double FORMAT = 1024.0;
		double kbNumber = byteNumber/FORMAT;
		if(kbNumber<FORMAT){
			return new DecimalFormat("#.##KB").format(kbNumber);
		}
		double mbNumber = kbNumber/FORMAT;
		if(mbNumber<FORMAT){
			return new DecimalFormat("#.##MB").format(mbNumber);
		}
		double gbNumber = mbNumber/FORMAT;
		if(gbNumber<FORMAT){
			return new DecimalFormat("#.##GB").format(gbNumber);
		}
		double tbNumber = gbNumber/FORMAT;
		return new DecimalFormat("#.##TB").format(tbNumber);
	}
}

