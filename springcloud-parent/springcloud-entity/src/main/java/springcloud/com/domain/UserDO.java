package springcloud.com.domain;

import java.util.Date;

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
	 
    /** 创建者 */
    private String createBy;

    /** 创建时间 */

    private Date createTime;

    /** 更新者 */

    private String updateBy;

    /** 更新时间 */
    private Date updateTime;
    
    /** 删除表示*/
    private String delFlag;
	 



	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

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
