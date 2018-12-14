package springcloud.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import springcloud.com.domain.UserDO;
import springcloud.com.dto.UserDTO;

@Service
public class UserService {

	@Autowired
	LoadBalancerClient loadBalancerClient; //负载均衡器
	
	public UserDO getUser() {
		//获取服务实例
		ServiceInstance si = loadBalancerClient.choose("eureka-base");
		//拼接
		StringBuffer sb = new StringBuffer();
		sb.append("http://").append(si.getHost()).append(":").append(si.getPort()).append("/user/15/selectOne");
		System.out.println(sb.toString());
		RestTemplate rt = new RestTemplate();
		UserDTO dto = new UserDTO();
		dto.setAge("20");
		dto.setName("惠松林");
		ParameterizedTypeReference<UserDO> type = new ParameterizedTypeReference<UserDO>() {};
		ResponseEntity<UserDO> rsp = rt.exchange(sb.toString(), HttpMethod.POST, new HttpEntity<UserDTO>(dto), type);
		UserDO userDO = rsp.getBody();
		return userDO;
	}
}
