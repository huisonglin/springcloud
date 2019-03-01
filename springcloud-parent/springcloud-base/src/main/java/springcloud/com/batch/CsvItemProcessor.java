/**
 * 
 */package springcloud.com.batch;

import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;

import springcloud.com.domain.Person;

/** 
* @author : 刘尊亮
* @date 创建时间：2019年3月1日 上午10:25:50 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * @author Administrator
 *
 */
public class CsvItemProcessor extends ValidatingItemProcessor<Person>{

	@Override
	public Person process(Person item) throws ValidationException {
		// TODO Auto-generated method stub
		 super.process(item);
		 if(item.getNation().equals("汉族")) {
			 item.setNation("01");
		 }else {
			 item.setName("02");
		 }
		 return item;
	}

	
}
