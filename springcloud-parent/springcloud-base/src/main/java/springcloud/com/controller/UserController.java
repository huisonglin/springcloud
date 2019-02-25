/**
 * 
 */package springcloud.com.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.converters.Auto;

import springcloud.com.domain.UserDO;
import springcloud.com.mapper.UserMapper;
import tk.mybatis.mapper.common.Mapper;

/** 
* @author : 刘尊亮
* @date 创建时间：2019年1月29日 上午11:24:04 
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
 @RequestMapping("/user")
public class UserController extends BaseController<UserDO>{

	 @Autowired
	 UserMapper userMapper;

	 //注入通用mapper对象
	 @Override
	 public void setMapper() {
		 System.out.println(userMapper); 
		 super.mapper = userMapper;
	 }

	 

	 







}
