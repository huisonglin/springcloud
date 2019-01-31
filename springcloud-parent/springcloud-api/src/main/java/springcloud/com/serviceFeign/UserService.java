/**
 * 
 */package springcloud.com.serviceFeign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import springcloud.com.domain.UserDO;

/** 
* @author : 刘尊亮
* @date 创建时间：2019年1月28日 下午5:39:09 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * @author Administrator
 *
 */

@RequestMapping("/user")
public interface UserService {

		@RequestMapping("/{id}/selectOne")
		public UserDO selectOne(@PathVariable("id") String id);
		
		@RequestMapping("/helloWord")
		public String helloWord(UserDO u);
		
		@RequestMapping("/nihao")
		public String nihao();
		
}
