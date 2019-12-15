package springcloud.com.vo;

import java.util.HashMap;
import java.util.Map;

import springcloud.com.em.SearchTypeEnum;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;


public class Search extends HashMap<String, Map<String, Object>>{

	public Search() {
		super();
	}
	public Search add(String filedName,String value) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("value", value);
		hashMap.put("searchType", SearchTypeEnum.EqualTo);
		super.put(filedName, hashMap);
		return this;
	}
	
	public Search add(String filedName,String value,SearchTypeEnum searType) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("value", value);
		hashMap.put("searchType", searType);
		super.put(filedName, hashMap);
		return this;
	}
	
    /**
     * 返回成功消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static Search addSearch(String filedName,String value) {
        return new Search(filedName, value);
    }
    
    public static Search addSearch(String filedName,String value,SearchTypeEnum searType) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("value", value);
		hashMap.put("searchType", searType);
        return new Search(filedName, value);
    }
    
    public Search(String filedName,String value) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("value", value);
		hashMap.put("searchType", SearchTypeEnum.EqualTo);
    	super.put(filedName, hashMap);
    }
    

}



