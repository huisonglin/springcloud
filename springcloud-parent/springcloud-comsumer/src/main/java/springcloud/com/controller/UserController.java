package springcloud.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springcloud.com.domain.UserDO;
import springcloud.com.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/getUser")
	public UserDO getUser() {
		return userService.getUser();
	}
}
