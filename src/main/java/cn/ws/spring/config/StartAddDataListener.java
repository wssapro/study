package cn.ws.spring.config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

@Service
public class StartAddDataListener implements ApplicationListener<ContextRefreshedEvent>
{

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){
        System.out.println("====================================================================================================项目启动之前");
    }

}