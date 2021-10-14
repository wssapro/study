package cn.ws.spring.config;

public class RabbitMqConstant
{

	/**
	 * 队列名称
	 */
	public static final String QUEUE_NAME = "MQ_QUEUE_STATISTICS_DYP";
	//String QUEUE_NAME = "PRODUCER_DEVICE_USER";
	/**
	 * 交换机名称
	 */
	public static final String EXCHANGE_NAME = "MQ_MESSAGE_PACKAGE";
	//String EXCHANGE_NAME = "EXCHANGE_DIRDCTOR_DEVICE_USER";
	/**
	 * 路由KEY值
	 */
	public static final String ROUTING_KEY = "MQ_PACKAGE_KEY";
	//String ROUTING_KEY = "DEVICE_USER";
}