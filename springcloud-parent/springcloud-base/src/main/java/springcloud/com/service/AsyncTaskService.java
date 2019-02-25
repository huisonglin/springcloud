package springcloud.com.service;


import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import redis.clients.jedis.Jedis;
import springcloud.com.vo.AsyncTaskVo;

@Service
public class AsyncTaskService {
	
	
	public void produceAsyncTask(AsyncTaskVo task) {
		Jedis jedis = new Jedis("YunJiKuRedis.redis.cache.chinacloudapi.cn", 6379);
		jedis.auth("/jq+6e4CyqOca8BSAZhv6XqcORRFLDSkqAVhc7V/dt4=");
		jedis.lpush("AYSNC_TASK_QUEUE", JSON.toJSONString(task));
		jedis.close();

	}

}
