/**
 * 
 */package springcloud.com.service.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import springcloud.com.domain.MemberDO;
import springcloud.com.serviceFeign.common.CommonInterface;

/** 
* @author : 刘尊亮
* @date 创建时间：2019年1月29日 下午2:32:43 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * @author Administrator
 *
 */
/*@RequestMapping("/member")*/
@FeignClient(name = "eureka-base",url = "http://127.0.0.1:9090/member")
public interface MemberFeign extends CommonInterface<MemberDO>{

}
