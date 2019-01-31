package springcloud.com.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import tk.mybatis.mapper.annotation.KeySql;



/**
 * 会员表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-10-07 11:45:05
 */
@Table(name = "yjk_member")
public class MemberDO implements Serializable {

	//主键ID
	@Id
	@KeySql(useGeneratedKeys=true)
	 private Long id;
	 
	 private String nick_name;
	 




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	

	 
	 

}
