package springcloud.com.vo;

public class AsyncSendSmsTaskVo {
	
	private Long id;
	
	
	private String content;
	
	private String phone;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "AsyncSendSmsTaskVo [content=" + content + ", phone=" + phone + "]";
	}
	
	

}
