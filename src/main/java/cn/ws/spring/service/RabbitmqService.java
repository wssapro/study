package cn.ws.spring.service;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Service;

/**
 * @author shun
 * @date 2021-04-23 10:28
 */
@Service
public class RabbitmqService
{

	//@RabbitHandler
	//@RabbitListener(bindings = @QueueBinding(value = @Queue(value = RabbitMqConstant.QUEUE_NAME), exchange = @Exchange(value =
	//		RabbitMqConstant.EXCHANGE_NAME), key = RabbitMqConstant.QUEUE_NAME))
	public void consumer(Channel channel, Message message)
	{
		try
		{
			String rabbitmqJson = new String(message.getBody());

			//if ("1".equals(Constant.PROJECT_CONFIG_MAP.get(ProjectConfigConstant.DCPACKAGE_LOG_SWITCH)))
			//{
			//	Log4j.NAME.LOGS_RABBITMQ.info(rabbitmqJson);
			//}

			channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		}
		catch (Exception e)
		{
			try
			{
				channel.basicRecover();
			}
			catch (Exception e1)
			{
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
