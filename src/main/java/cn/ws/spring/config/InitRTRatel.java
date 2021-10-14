package cn.ws.spring.config;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * 常量
 *
 * @author shun
 * @date 2020-09-07 18:04
 */
@Service
public class InitRTRatel implements CommandLineRunner
{

	@PostConstruct
	public void init()
	{
		try
		{
			System.out.println("====================================================================================================PostConstruct");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void run(String... args) {
		try
		{
			System.out.println("====================================================================================================项目已经启动成功");

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
