/**
 * 
 */package springcloud.com.controller;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
* @author : 刘尊亮
* @date 创建时间：2019年3月1日 下午4:02:17 
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
public class BatchProcessorController {

/*	 @Autowired
	 JobLauncher jobLauncher;
	 @Autowired
	 Job importJob;
	 
	 public JobParameters jobParameters;
	 
	 @RequestMapping("/imp")
	 public String imp(String fileName) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		 String path = fileName + ".csv"; 
		 jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
				 .addString("input.file.name", path).toJobParameters();
		 jobLauncher.run(importJob, jobParameters);
		 return "ok";
	 }*/
}
