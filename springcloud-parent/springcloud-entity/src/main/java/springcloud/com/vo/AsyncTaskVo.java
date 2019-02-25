package springcloud.com.vo;

import java.util.UUID;

import com.alibaba.fastjson.JSONObject;

import springcloud.com.em.AsyncTaskType;



public class AsyncTaskVo {

    private String taskId = UUID.randomUUID().toString();
	
	private AsyncTaskType taskType;
	
	private JSONObject taskBody;

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public AsyncTaskType getTaskType() {
		return taskType;
	}

	public void setTaskType(AsyncTaskType taskType) {
		this.taskType = taskType;
	}

	public JSONObject getTaskBody() {
		return taskBody;
	}

	public void setTaskBody(JSONObject taskBody) {
		this.taskBody = taskBody;
	}

	@Override
	public String toString() {
		return "AsyncTaskVo [taskId=" + taskId + ", taskType=" + taskType + ", taskBody=" + taskBody + "]";
	}

	
	
	
		
}
