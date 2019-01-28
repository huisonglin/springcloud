package springcloud.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.converters.Auto;

import springcloud.com.domain.UserDO;

import springcloud.com.service.feign.UserFeign;
import springcloud.com.serviceFeign.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
/*	@Autowired
	UserService userService;
	@Autowired
	UserFeign userFeign;
	
	@RequestMapping("/getUser")
	public UserDO getUser() {
		System.out.println("我是feign");
		return userService.getUser();
	}
	
	@RequestMapping("/hello")
	public String helloWorld() {
		return userFeign.helloWord();
	}*/
	
	@RequestMapping("/getUser")
	public String getUser() {
		System.out.println("我是feign");
		return userService.helloWord(); 
	}
}
