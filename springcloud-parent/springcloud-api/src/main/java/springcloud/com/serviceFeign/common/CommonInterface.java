/**
 * 
 */package springcloud.com.serviceFeign.common;

import java.util.List;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;


/** 
* @author : 刘尊亮
* @date 创建时间：2019年1月29日 上午10:43:45 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * @author Administrator
 * @param <T>
 *
 */

public interface CommonInterface<T>{

	
	
	@PostMapping("/delete")
	int delete(@RequestBody T record);


	@RequestMapping("/existsWithPrimaryKey")
	boolean existsWithPrimaryKey(@RequestHeader("key") Object key);


	@RequestMapping("/updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(@RequestBody T record);


	@RequestMapping("/selectCount")
	int selectCount(@RequestBody T record);


	@RequestMapping("/selectByExample")
	List<T> selectByExample(@RequestBody Object example);


	@RequestMapping("/selectOneByExample")
	T selectOneByExample(@RequestBody Object example);
	
	@RequestMapping("/{key}/selectByPrimaryKey")
	T selectByPrimaryKey(@PathVariable("key") Object key);
	
	@RequestMapping("/add")
	public int insert(@RequestBody T example);

	
}
