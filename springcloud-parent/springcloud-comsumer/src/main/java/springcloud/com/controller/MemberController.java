/**
 * 
 */package springcloud.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springcloud.com.domain.MemberDO;
import springcloud.com.service.feign.MemberFeign;

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
		 MemberDO selectByPrimaryKey = memberFeign.selectByPrimaryKey(1L);
		 return selectByPrimaryKey;
	 }
}
