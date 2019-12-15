/**
 * 
 */package springcloud.com.serviceFeign.common;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import springcloud.com.vo.Search;



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

	@GetMapping("/get/{id}")
	public T get(@PathVariable(name="id")Long id);
	
	@PostMapping("/add")
	public Boolean add(@RequestBody T record);
	
	@PostMapping("/update")
	public Boolean update(@RequestBody T record) throws Exception ;
	
	@GetMapping("/delete/{id}/{updateBy}")
	public Boolean delete(@PathVariable(name = "id")Long id,@PathVariable(name = "updateBy")String updateBy) throws Exception; 
	
	@PostMapping("/getList")
	public List<T> getList(@RequestBody Search search);

	
}
