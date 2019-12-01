package springcloud.com.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springcloud.com.domain.UserDO;
import springcloud.com.serviceFeign.common.CommonInterface;
import tk.mybatis.mapper.common.Mapper;


public abstract class BaseController<T> implements CommonInterface<T>{
	
	@Autowired
	Mapper<T> mapper;
	
	
	@Override
	public int delete(@RequestBody T record) {
		return mapper.delete(record);
	}


	@Override
	public boolean existsWithPrimaryKey(@RequestHeader("key") Object key) {
		return mapper.existsWithPrimaryKey(key);
	}


	@Override
	public int updateByPrimaryKeySelective(@RequestBody T record) {
		return 0;
	}


	@Override
	public int selectCount(@RequestBody T record) {
		return mapper.selectCount(record);
	}


	@Override
	public List<T> selectByExample(@RequestBody Object example) {
		return mapper.selectByExample(example);
	}


	@Override
	public T selectOneByExample(@RequestBody Object example) {
		return mapper.selectOneByExample(example);
	}

	@Override
	public T selectByPrimaryKey(@PathVariable("key") Object key) {
		return mapper.selectByPrimaryKey(key);
	}
	
	public int insert(@RequestBody T example) {
		 return mapper.insertSelective(example);
	}
	
	
}
