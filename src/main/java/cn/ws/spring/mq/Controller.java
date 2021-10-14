package cn.ws.spring.mq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/")
    public String sayHello() {
        rabbitTemplate.convertAndSend("delayExchange", "delayKey", "this is a message ",
                message -> {
                    //设置10秒过期
                    message.getMessageProperties()
                            .setExpiration("10000");
                    return message;
                });
        return "Hello,World!";
    }
}
