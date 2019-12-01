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
import springcloud.com.serviceFeign.common.CommonInterface;


@FeignClient(name = "eureka-base",path="user")
public interface UserFeign extends CommonInterface<UserDO>{

	
}