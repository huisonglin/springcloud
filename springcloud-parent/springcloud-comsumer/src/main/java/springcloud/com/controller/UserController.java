package springcloud.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.converters.Auto;

import springcloud.com.domain.UserDO;

import springcloud.com.service.feign.UserFeign;

@RestController
public class UserController {

	@Autowired
	UserFeign userFeign;
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
	public UserDO getUser(Long id) {
		UserDO userDO = userFeign.selectByPrimaryKey(id);
		return userDO;
	}
	
	@RequestMapping("/add")
	public String add(UserDO user) {
		 int insert = userFeign.insert(user);
		 return "succeses"+insert;
	}
	
	
}
