package springcloud.com.comsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import springcloud.com.feign.MemberFeign;
import springcloud.com.vo.AsyncSendSmsTaskVo;
import springcloud.com.vo.AsyncTaskVo;

@Component("CONSUMER_SEND_SMS")
public class SendSmsConsumer implements AsyncTaskConsumer{

	@Autowired
	MemberFeign memberFeign;
	
	@Override
	public void consumer(AsyncTaskVo task) {
		
		AsyncSendSmsTaskVo sendSmsTask = JSON.toJavaObject(task.getTaskBody(), AsyncSendSmsTaskVo.class);
		memberFeign.sendSms(sendSmsTask);
	}

}
