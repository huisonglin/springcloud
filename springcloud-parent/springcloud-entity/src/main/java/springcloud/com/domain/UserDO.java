package springcloud.com.domain;

import javax.persistence.Id;
import javax.persistence.Table;

import tk.mybatis.mapper.annotation.KeySql;

@Table(name = "user")
public class UserDO {

	//主键ID
	@Id
	@KeySql(useGeneratedKeys=true)
	 private Long id;
	 
	 private String name;
	 
	 private String age;
	 



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserDO [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	


	 

}
