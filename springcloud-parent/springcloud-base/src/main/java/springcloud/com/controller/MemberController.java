/**
 * 
 */package springcloud.com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springcloud.com.domain.MemberDO;
import springcloud.com.mapper.MemberMapper;
import springcloud.com.vo.AsyncSendSmsTaskVo;

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

	@Autowired
	MemberMapper memberMapper;

	/* (non-Javadoc)
	 * @see springcloud.com.controller.BaseController#setMapper()
	 */
	@Override
	public void setMapper() {
		// TODO Auto-generated method stub
		 System.out.println(memberMapper); 
		 super.mapper = memberMapper; 
	}
	
	@RequestMapping("sendSms")
	public void sendSms(@RequestBody AsyncSendSmsTaskVo asyncSendSmsTaskVo) {
		
		System.out.println("我已经在处理了"+asyncSendSmsTaskVo);
		
		MemberDO selectByPrimaryKey = memberMapper.selectByPrimaryKey(asyncSendSmsTaskVo.getId());
		System.out.println(selectByPrimaryKey);
	}






}
