/**
 * 
 */package springcloud.com.batch;

import java.util.List;

import org.springframework.batch.core.ItemWriteListener;

import springcloud.com.domain.Person;

/** 
* @author : 刘尊亮
* @date 创建时间：2019年3月1日 下午5:38:14 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * @author Administrator
 *
 */
public class WriteListener implements ItemWriteListener<Person>{

	Long startTime;
	
	Long endTime;
	/* (non-Javadoc)
	 * @see org.springframework.batch.core.ItemWriteListener#beforeWrite(java.util.List)
	 */
	@Override
	public void beforeWrite(List<? extends Person> items) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		startTime = System.currentTimeMillis();
		System.out.println("写任务开始");
		
	}

	/* (non-Javadoc)
	 * @see org.springframework.batch.core.ItemWriteListener#afterWrite(java.util.List)
	 */
	@Override
	public void afterWrite(List<? extends Person> items) {
		// TODO Auto-generated method stub
		endTime = System.currentTimeMillis();
		System.out.println("写任务结束");
		System.out.println("耗时:"+(endTime - startTime)+"毫秒");
		
	}

	/* (non-Javadoc)
	 * @see org.springframework.batch.core.ItemWriteListener#onWriteError(java.lang.Exception, java.util.List)
	 */
	@Override
	public void onWriteError(Exception exception, List<? extends Person> items) {
		// TODO Auto-generated method stub
		
	}

}
