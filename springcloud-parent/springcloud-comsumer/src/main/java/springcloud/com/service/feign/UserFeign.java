package springcloud.com.service.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import springcloud.com.domain.UserDO;
import springcloud.com.serviceFeign.UserService;
import springcloud.com.serviceFeign.common.CommonInterface;


@FeignClient("eureka-base")
public interface UserFeign  extends CommonInterface<UserDO>{

//	@RequestMapping("/user/{id}/selectOne")
//	public UserDO selectOne(@PathVariable("id") String id);
}
//@Component
//class FeignFallback1 implements UserFeign{
//
//	@Override
//	public UserDO selectOne(@PathVariable("id") String id) {
//		// TODO Auto-generated method stub
//		UserDO u = new UserDO();
//		u.setAddress("我是断路器");
//		u.setAge("17");
//		return u;
//	}

//}