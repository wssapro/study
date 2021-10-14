package cn.ws.spring.config;

import cn.ws.spring.log.Log4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * rabbitMq配置文件
 *
 * @author shun
 * @date 2021-04-22 17:55
 */
@Configuration
public class RabbitmqConfig
{

	@Bean
	public RabbitTemplate rabbitTemplate(CachingConnectionFactory connectionFactory)
	{
		connectionFactory.setPublisherConfirms(true);
		connectionFactory.setPublisherReturns(true);
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMandatory(true);
		rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> Log4j.NAME.LOGS_SOUT.info("消息发送成功:correlationData({}),ack({}),cause({})",
				correlationData, ack, cause));
		rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> Log4j.NAME.LOGS_SOUT.info("消息丢失:exchange({}),route" +
				"({}),replyCode({}),replyText({}),message:{}", exchange, routingKey, replyCode, replyText, message));
		return rabbitTemplate;
	}

	/**
	 * 注册队列
	 *
	 * @param
	 * @return org.springframework.amqp.core.Queue
	 * @author shun
	 * @date 2021/4/22
	 */
	@Bean
	public Queue packageQueue()
	{
		// durable:是否持久化,默认是false,持久化队列：会被存储在磁盘上，当消息代理重启时仍然存在，暂存队列：当前连接有效
		// exclusive:默认也是false，只能被当前创建的连接使用，而且当连接关闭后队列即被删除。此参考优先级高于durable
		// autoDelete:是否自动删除，当没有生产者或者消费者使用此队列，该队列会自动删除。
		//一般设置一下队列的持久化就好,其余两个就是默认false
		return new Queue(RabbitMqConstant.QUEUE_NAME, false, false, false);
	}

	/**
	 * 注册交换机
	 *
	 * @param
	 * @return org.springframework.amqp.core.DirectExchange
	 * @author shun
	 * @date 2021/4/22
	 */
	@Bean
	public DirectExchange packageExchange()
	{
		return new DirectExchange(RabbitMqConstant.EXCHANGE_NAME, true, false);
	}

	/**
	 * 将队列和交换机绑定
	 *
	 * @param
	 * @return org.springframework.amqp.core.Binding
	 * @author shun
	 * @date 2021/4/22
	 */
	@Bean
	public Binding packageBinding()
	{
		return BindingBuilder.bind(packageQueue()).to(packageExchange()).with(RabbitMqConstant.ROUTING_KEY);
	}

}