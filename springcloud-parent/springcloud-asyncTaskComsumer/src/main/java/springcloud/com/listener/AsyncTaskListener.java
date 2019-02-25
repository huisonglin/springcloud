/**
 * 
 */package springcloud.com.listener;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.impl.execchain.MainClientExec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
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
		

			dealMessage();
		


		
	}
	/**
	 * 
	 */
	private void dealMessage() {
		try {
			Jedis jedis = new Jedis("YunJiKuRedis.redis.cache.chinacloudapi.cn", 6379);
			jedis.auth("/jq+6e4CyqOca8BSAZhv6XqcORRFLDSkqAVhc7V/dt4=");
			List<String> brpop = jedis.brpop(3000, Constants.ASYNC_TASK_QUEUE);
			for (String string : brpop) {
				System.out.println(string);
			}
		} catch (Exception e) {
			System.out.println("正在尝试重连！！！");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			dealMessage();
		}
	}
//	public static void main(String[] args) {
////		AsyncTaskListener asyncTaskListener= new AsyncTaskListener();
////		asyncTaskListener.dealMessage();
//		Jedis jedis = new Jedis("YunJiKuRedis.redis.cache.chinacloudapi.cn", 6379);
//		jedis.auth("/jq+6e4CyqOca8BSAZhv6XqcORRFLDSkqAVhc7V/dt4=");
//		List<String> brpop = jedis.blpop(arg)
//		for (String string : brpop) {
//			System.out.println(string);
//		}
//	}
}
