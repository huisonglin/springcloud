package springcloud.com.service.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import springcloud.com.domain.UserDO;
import springcloud.com.serviceFeign.UserService;
import springcloud.com.serviceFeign.common.CommonInterface;


@FeignClient("eureka-base")
public interface UserFeign{

	@PostMapping("/user/delete")
	int delete(@RequestBody UserDO record);


	@RequestMapping("/user/existsWithPrimaryKey")
	boolean existsWithPrimaryKey(@RequestHeader("key") Object key);


	@RequestMapping("/user/updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(@RequestBody UserDO record);


	@RequestMapping("/user/selectCount")
	int selectCount(@RequestBody UserDO record);


	@RequestMapping("/user/selectByExample")
	List<UserDO> selectByExample(@RequestBody Object example);


	@RequestMapping("/user/selectOneByExample")
	UserDO selectOneByExample(@RequestBody Object example);
	
	@RequestMapping("user/{key}/selectByPrimaryKey")
	UserDO selectByPrimaryKey(@PathVariable("key") Object key);
	
}