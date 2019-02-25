package springcloud.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springcloud.com.service.AsyncTaskService;
import springcloud.com.vo.AsyncTaskVo;


@RestController
@RequestMapping("/asyncTask")
public class AsyncTaskController {
	
	@Autowired
	private AsyncTaskService asyncTaskService;

	@PostMapping("/produce")
	public void produceAsyncTask(@RequestBody AsyncTaskVo task){
		this.asyncTaskService.produceAsyncTask(task);
	}
}
