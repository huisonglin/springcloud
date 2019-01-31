/**
 * 
 */package springcloud.com.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springcloud.com.domain.MemberDO;
import springcloud.com.mapper.MemberMapper;

/** 
* @author : 刘尊亮
* @date 创建时间：2019年1月29日 下午2:30:57 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/member")
public class MemberController extends BaseController<MemberDO>{

	/* (non-Javadoc)
	 * @see springcloud.com.controller.BaseController#setMapper()
	 */
	@Override
	public void setMapper() {
		// TODO Auto-generated method stub
		
	}





}
