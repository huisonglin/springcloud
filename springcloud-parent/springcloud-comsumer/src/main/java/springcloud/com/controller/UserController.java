package springcloud.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.converters.Auto;

import springcloud.com.domain.UserDO;

import springcloud.com.service.feign.UserFeign;
import springcloud.com.vo.Search;

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
		UserDO userDO = userFeign.get(id);
		return userDO;
	}
	
	@RequestMapping("/add")
	public String add(UserDO user) {
		 Boolean add = userFeign.add(user);
		 return "succeses";
	}
	@RequestMapping("/delete")
	public String delete(Long id,String updateBy) throws Exception {
		@SuppressWarnings("unused")
		Boolean delete = userFeign.delete(id, updateBy);
		return "success";
	}
	
	@RequestMapping("/update")
	public String update(UserDO record) throws Exception {
		@SuppressWarnings("unused")
		Boolean update = userFeign.update(record);
		return "success";
	}
	
	@ResponseBody
	@RequestMapping("/search")
	public List<UserDO> search(String name) {
		return userFeign.getList(new Search("name", name));
	}
}
