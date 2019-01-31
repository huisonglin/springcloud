/**
 * 
 */package springcloud.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springcloud.com.domain.MemberDO;
import springcloud.com.domain.UserDO;
import springcloud.com.mapper.UserMapper;

/** 
* @author : 刘尊亮
* @date 创建时间：2019年1月29日 下午1:24:38 
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
	 MemberController m;
	 @Autowired
	 UserController u;
	 @Autowired
	 UserMapper userMapper;
	 @RequestMapping("test")
	 public UserDO test() {
		 	System.out.println(u);
		 	System.out.println(m);
		 	MemberDO selectByPrimaryKey = m.selectByPrimaryKey(1L);
		 	UserDO selectByPrimaryKey2 = u.selectByPrimaryKey(1L);
		 	return null;
	 }
}
