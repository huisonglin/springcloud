/**
 * 
 */package springcloud.com.batch;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/** 
* @author : 刘尊亮
* @date 创建时间：2019年3月1日 上午10:39:40 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * @author Administrator
 *
 */
public class CsvJobListener implements JobExecutionListener{

	Long startTime;
	
	Long endTime;
	/* (non-Javadoc)
	 * @see org.springframework.batch.core.JobExecutionListener#afterJob(org.springframework.batch.core.JobExecution)
	 */
	@Override
	public void afterJob(JobExecution arg0) {
		// TODO Auto-generated method stub
		endTime = System.currentTimeMillis();
		System.out.println("任务处理结束");
		System.out.println("耗时:"+(endTime - startTime)+"毫秒");
		
	}

	/* (non-Javadoc)
	 * @see org.springframework.batch.core.JobExecutionListener#beforeJob(org.springframework.batch.core.JobExecution)
	 */
	@Override
	public void beforeJob(JobExecution arg0) {
		// TODO Auto-generated method stub
		startTime = System.currentTimeMillis();
		System.out.println("任务处理开始");
		
		
	}

}
