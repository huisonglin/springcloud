/**
 * 
 */package springcloud.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import springcloud.com.domain.MemberDO;
import springcloud.com.em.AsyncTaskType;
import springcloud.com.service.feign.MemberFeign;
import springcloud.com.vo.AsyncSendSmsTaskVo;
import springcloud.com.vo.AsyncTaskVo;

/** 
* @author : 刘尊亮
* @date 创建时间：2019年1月29日 下午2:33:43 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * @author Administrator
 *
 */
 @RestController
public class MemberController {

	 @Autowired
	 MemberFeign memberFeign;
	 
	 @RequestMapping("ss")
	 public MemberDO member() {
		 MemberDO selectByPrimaryKey = memberFeign.get(116L);
		 return selectByPrimaryKey;
	 }
	 
	 @RequestMapping("/asyn")
	 public String testasyn(Long id) {
		 AsyncTaskVo asyncTaskVo = new AsyncTaskVo();
		 asyncTaskVo.setTaskType(AsyncTaskType.SEND_SMS);
		 AsyncSendSmsTaskVo asyncSendSmsTaskVo = new AsyncSendSmsTaskVo();
		 asyncSendSmsTaskVo.setContent("你好世界");
		 asyncSendSmsTaskVo.setId(id);
		 asyncTaskVo.setTaskBody((JSONObject)JSON.toJSON(asyncSendSmsTaskVo));
//		 memberFeign.produceAsyncTask(asyncTaskVo);
		 return "SUCCESS";
	 }
}
