package springcloud.com.comsumer;

import springcloud.com.vo.AsyncTaskVo;

public interface AsyncTaskConsumer {
	
	public void consumer(AsyncTaskVo task);

}
