package cn.ws.spring.mq;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 描述：消息消费者
 *
 * @RabbitListener注解定义该类对hello队列的监听， 并用@RabbitHandler注解来指定对消息的处理方法。
 * 所以，该消费者实现了对hello队列的消费，消费操作为输出消息的字符串内容
 */
@Component
public class Receiver {


    @RabbitListener(bindings = @QueueBinding(value = @Queue("dlxQueue"), exchange = @Exchange("dlxExchange"), key = "dlxKey"))
    public void process(Message message, Channel channel) throws IOException {
        // 采用手动应答模式, 手动确认应答更为安全稳定
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        System.out.println(new String(message.getBody()));
    }
}
