/**
 * 
 */package springcloud.com.service.feign;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springcloud.com.domain.MemberDO;
import springcloud.com.serviceFeign.common.CommonInterface;
import springcloud.com.vo.AsyncTaskVo;

/** 
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

@FeignClient(name = "eureka-base",path="member")
public interface MemberFeign extends CommonInterface<MemberDO>{
	
				
/*	@PostMapping("/asyncTask/produce")
	public void produceAsyncTask(@RequestBody AsyncTaskVo task);
	
	@PostMapping("/member/delete")
	int delete(@RequestBody MemberDO record);


	@RequestMapping("/member/existsWithPrimaryKey")
	boolean existsWithPrimaryKey(@RequestHeader("key") Object key);


	@RequestMapping("/member/updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(@RequestBody MemberDO record);


	@RequestMapping("/member/selectCount")
	int selectCount(@RequestBody MemberDO record);


	@RequestMapping("/member/selectByExample")
	List<MemberDO> selectByExample(@RequestBody Object example);


	@RequestMapping("/member/selectOneByExample")
	MemberDO selectOneByExample(@RequestBody Object example);
	
	@RequestMapping("/member/{key}/selectByPrimaryKey")
	MemberDO selectByPrimaryKey(@PathVariable("key") Object key);*/
}
