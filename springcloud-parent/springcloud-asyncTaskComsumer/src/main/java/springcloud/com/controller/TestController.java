/**
 * 
 */package springcloud.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
* @author : 刘尊亮
* @date 创建时间：2019年2月25日 下午5:41:19 
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
public class TestController {

	 @Autowired
	 RedisTemplate redisTemplate;
	 
	 @RequestMapping("test")
	 public String test(){
		 return redisTemplate.toString();
	 }
}
