/**
 * 
 */package springcloud.com.listener;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.impl.execchain.MainClientExec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import redis.clients.jedis.Jedis;
import springcloud.com.common.Constants;
import springcloud.com.comsumer.AsyncTaskConsumer;
import springcloud.com.vo.AsyncTaskVo;

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
	 
	@Autowired
	private ApplicationContext springContext;
		
	@Override
	public void run(String... args) throws Exception {
		System.out.println("我正在监听咯！！！");
		dealMessage();
	}
	/**
	 * 
	 */
	private void dealMessage() {
		Jedis jedis = new Jedis("YunJiKuRedis.redis.cache.chinacloudapi.cn", 6379);
		jedis.auth("/jq+6e4CyqOca8BSAZhv6XqcORRFLDSkqAVhc7V/dt4=");
		while(true) {
			try {
				List<String> brpop = jedis.brpop(0, Constants.ASYNC_TASK_QUEUE);
				if(brpop.size() == 2) {
					Thread.sleep(1000);
					String msgBody = brpop.get(1);
					System.out.println("接收异步任务： " + msgBody);
					AsyncTaskVo task = JSON.parseObject(msgBody, AsyncTaskVo.class);
					String consumerBeanName = "CONSUMER_" + task.getTaskType().getValue();
					AsyncDeal(task, consumerBeanName);
				}

			} catch (Exception e) {
				e.printStackTrace();
				if(jedis != null) {
					jedis.close();
				}
				System.out.println("正在尝试重连！！！");
				try {
					Thread.sleep(5000);
					try {
						jedis = new Jedis("YunJiKuRedis.redis.cache.chinacloudapi.cn", 6379);
						jedis.auth("/jq+6e4CyqOca8BSAZhv6XqcORRFLDSkqAVhc7V/dt4=");
					} catch (Exception e1) {
						e1.printStackTrace();
						// TODO Auto-generated catch block
						System.out.println("从新建立连接还是失败！！！！");
					}
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
			}
		}
	}
	
	@Async
	private void AsyncDeal(AsyncTaskVo task, String consumerBeanName) {
		AsyncTaskConsumer consumer = (AsyncTaskConsumer)this.springContext.getBean(consumerBeanName);
		if(consumer == null) {
			System.out.println("找不到任务处理bean： {}");
			return;
		}
		consumer.consumer(task);
	}

}
