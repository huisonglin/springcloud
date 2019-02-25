/**
 * 
 */package springcloud.com.listener;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import springcloud.com.common.Constants;

/** 
* @author : 刘尊亮
* @date 创建时间：2019年2月25日 下午5:45:31 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * @author Administrator
 *
 */
 @Component
public class AsyncTaskListener implements CommandLineRunner{

	/* (non-Javadoc)
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	 @Autowired
	 RedisTemplate redisTemplate;
	@Override
	public void run(String... args) throws Exception {
		System.out.println("我正在监听咯！！！");
		
		ListOperations opsForList = redisTemplate.opsForList();
		while(true) {
			Object leftPop = opsForList.leftPop(Constants.ASYNC_TASK_QUEUE, 3, TimeUnit.SECONDS);
			System.out.println("我收到您发来的消息为：" + leftPop);
		}


		
	}

}
