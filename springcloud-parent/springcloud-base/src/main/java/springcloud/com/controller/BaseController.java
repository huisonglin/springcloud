package springcloud.com.controller;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.alibaba.fastjson.JSON;

import springcloud.com.em.SearchTypeEnum;
import springcloud.com.exception.BusinessException;
import springcloud.com.serviceFeign.common.CommonInterface;
import springcloud.com.utils.Convert;
import springcloud.com.vo.Search;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;


public abstract class BaseController<T> implements CommonInterface<T>{
	


	@Autowired
	Mapper<T> mapper;
	
	@Autowired
	ValueOperations<String, String> valueOperations;
	
	@Autowired
	RedisTemplate redisTemplate;
	
    private Class<T> modelClass;    // 当前泛型真实类型的Class

    @SuppressWarnings("unchecked")
	public BaseController() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }
	

	public Boolean add(@RequestBody T record) {
	       // 通过属性获取对象的属性
		String createBy = null;
		try {
			Field field = record.getClass().getDeclaredField("createBy");
	        field.setAccessible(true);
	        Object object = field.get(record);
	        createBy = object.toString();
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		
		if(StringUtils.isBlank(createBy)) {
			throw new BusinessException("创建人不能为空");
		}
		if(record == null) {
			throw new BusinessException("实体不能为空");
		}
		
        try {
			Field delFlag = modelClass.getDeclaredField("delFlag");
			delFlag.setAccessible(true);
			delFlag.set(record, "U");
			
			
			Field createUser = modelClass.getDeclaredField("createBy");
			createUser.setAccessible(true);
			createUser.set(record, createBy);
			
			Field updateUser = modelClass.getDeclaredField("updateBy");
			updateUser.setAccessible(true);
			updateUser.set(record, createBy);
			
			Field createDate = modelClass.getDeclaredField("createTime");
			createDate.setAccessible(true);
			createDate.set(record, new Date());
			
			
			Field updateDate = modelClass.getDeclaredField("updateTime");
			updateDate.setAccessible(true);
			updateDate.set(record, new Date());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		int result = mapper.insert(record);
		if(result > 0) {
			return true;
		}else {
			return false;
		}

	}

	public Boolean update(@RequestBody T record) throws Exception {
		Long id  = null;
		String updateBy = null;
		try {
			Field field = record.getClass().getDeclaredField("updateBy");
	        field.setAccessible(true);
	        Object object = field.get(record);
	        updateBy = object.toString();
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		
		try {
			Field field = record.getClass().getDeclaredField("id");
	        field.setAccessible(true);
	        Object object = field.get(record);
	        id = Convert.toLong(object);
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		
		
		if(id == null) {
			throw new BusinessException("id不能为空");
		}
		if(StringUtils.isBlank(updateBy)) {
			throw new BusinessException("更新人不能为空");
		}
		if(record == null) {
			throw new BusinessException("实体不能为空");
		}
		
        Field idField = modelClass.getDeclaredField("id");
        idField.setAccessible(true);
        idField.set(record, id);
		
        Field updateUser = modelClass.getDeclaredField("updateBy");
        updateUser.setAccessible(true);
        updateUser.set(record, updateBy);
        
        
        
        Field updateDate = modelClass.getDeclaredField("updateTime");
        updateDate.setAccessible(true);
        updateDate.set(record, new Date());
        
        int result = mapper.updateByPrimaryKeySelective(record);
        if(result > 0) {
        	redisTemplate.delete(new StringBuilder(modelClass.toString()).append("_").append(id).toString());
        	return true;
        }else {
        	return false;
        }
	}

	public Boolean delete(@PathVariable(name = "id")Long id,@PathVariable(name = "updateBy") String updateBy) throws Exception {
		
		if(id == null) {
			throw new BusinessException("id不能为空");
		}
		if(StringUtils.isBlank(updateBy)) {
			throw new BusinessException("更新人不能为空");
		}
		
        T model = modelClass.newInstance();
        Field field = modelClass.getDeclaredField("id");
        field.setAccessible(true);
        field.set(model, id);
        
        Field idField = modelClass.getDeclaredField("delFlag");
        idField.setAccessible(true);
        idField.set(model, "D");
        
        Field updateByField = modelClass.getDeclaredField("updateBy");
        updateByField.setAccessible(true);
        updateByField.set(model, updateBy);
        
        Field updateDate = modelClass.getDeclaredField("updateTime");
        updateDate.setAccessible(true);
        updateDate.set(model, new Date());
        
        int result = mapper.updateByPrimaryKeySelective(model);
        if(result > 0) {
        	redisTemplate.delete(new StringBuilder(modelClass.toString()).append("_").append(id).toString());
        	return true;
        }else {
        	return false;
        }
	}
	
	public T get(@PathVariable(name="id") Long id) {
		if(id == null) {
			return null;
		}
	 String object = valueOperations.get(new StringBuilder(modelClass.toString()).append("_").append(id).toString());
	 if(object == null) { 
		 synchronized (this) { //防止缓存穿透
				Example example = new Example(modelClass);
				Criteria criteria = example.createCriteria();
				criteria.andEqualTo("id",id);
				criteria.andEqualTo("delFlag","U");
				List<T> selectByExample = mapper.selectByExample(example);
				if(CollectionUtils.isEmpty(selectByExample)) {
					return null;
				}else {
					if(selectByExample.size() > 1) {
						throw new BusinessException("期待一条，实际查出两条");
					}
					 T t = selectByExample.get(0);
					 valueOperations.set(new StringBuilder(modelClass.toString()).append("_").append(id).toString(), JSON.toJSONString(t));
					 return t;		 
				}
		}
	 }else {
		return JSON.parseObject(object, modelClass);
	 }

	}
	

	public List<T> getList(@RequestBody Search search){
		
		Example example = new Example(modelClass);
		Criteria criteria = example.createCriteria();
		Set<String> keySet = search.keySet();
		if(CollectionUtils.isEmpty(keySet)) {
			return new ArrayList<>();
		}
		for (String field : keySet) {
			Map<String, Object> vts = search.get(field);
			if(SearchTypeEnum.EqualTo.toString().equals(vts.get("searchType"))) {
				
				criteria.andEqualTo(field, Convert.toStr(vts.get("value")));
				
			}else if(SearchTypeEnum.Like.toString().equals(vts.get("searchType"))) {
				
				criteria.andLike(field, Convert.toStr(vts.get("value")));
				
			}else if(SearchTypeEnum.GreaterThan.toString().equals(vts.get("searchType"))) {
				
				criteria.andGreaterThan(field, Convert.toStr(vts.get("value")));
				
			}else if(SearchTypeEnum.GreaterThanOrEqual.toString().equals(vts.get("searchType"))) {
				
				criteria.andGreaterThanOrEqualTo(field, Convert.toStr(vts.get("value")));
				
			}else if(SearchTypeEnum.IsNotNull.toString().equals(vts.get("searchType"))) {
				
				criteria.andIsNotNull(field);
				
			}else if(SearchTypeEnum.IsNull.toString().equals(vts.get("searchType"))) {
				
				criteria.andIsNull(field);
				
			}else if(SearchTypeEnum.LessThan.toString().equals(vts.get("searchType"))) {
				
				criteria.andLessThan(field, Convert.toStr(vts.get("value")));
				
			}else if(SearchTypeEnum.LessThanOrEqual.toString().equals(vts.get("searchType"))) {
				
				criteria.andLessThanOrEqualTo(field, Convert.toStr(vts.get("value")));
				
			}else if(SearchTypeEnum.NotEqual.toString().equals(vts.get("searchType"))) {
				
				criteria.andNotEqualTo(field, Convert.toStr(vts.get("value")));
				
			}


		}	
		criteria.andEqualTo("delFlag","U");
		return mapper.selectByExample(example);

	}
	

	
}
