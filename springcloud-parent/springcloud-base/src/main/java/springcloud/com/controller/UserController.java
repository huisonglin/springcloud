package springcloud.com.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springcloud.com.domain.UserDO;
import springcloud.com.dto.UserDTO;
import springcloud.com.serviceFeign.UserService;

@RestController
public class UserController implements UserService{

	/* (non-Javadoc)
	 * @see springcloud.com.serviceFeign.UserService#selectOne(java.lang.String)
	 */
	@Override
	public UserDO selectOne(String id) {
		System.out.println("我被调用了！"+id+"------------");
		UserDO userDO = new UserDO();
		userDO.setAddress("安徽省舒城县");
		userDO.setAge("18");
		userDO.setId("1");
		userDO.setName("张三疯");
		return userDO;	
	}

	/* (non-Javadoc)
	 * @see springcloud.com.serviceFeign.UserService#helloWord()
	 */
	@Override
	public String helloWord() {
		// TODO Auto-generated method stub
		return "helloWorld";
	}

	/* (non-Javadoc)
	 * @see springcloud.com.serviceFeign.UserService#nihao()
	 */
	@Override
	public String nihao() {
		// TODO Auto-generated method stub
		return "niaho";
	}

	
//	@RequestMapping("/user/{id}/selectOne")
//	public UserDO selectOne(@PathVariable("id") String id) {
//		System.out.println("我被调用了！"+id+"------------");
//		UserDO userDO = new UserDO();
//		userDO.setAddress("安徽省舒城县");
//		userDO.setAge("18");
//		userDO.setId("1");
//		userDO.setName("张三疯");
//		return userDO;	
//	}
}
