/**
 * 
 */package springcloud.com.batch;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;

import org.springframework.batch.item.validator.ValidationException;
import org.springframework.beans.factory.InitializingBean;

/** 
* @author : 刘尊亮
* @date 创建时间：2019年3月1日 上午10:29:40 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * @author Administrator
 *
 */
public class CsvBeanValidator<T>  implements org.springframework.batch.item.validator.Validator<T>,InitializingBean{

	private Validator validator;
	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.usingContext().getValidator();
	}
	/* (non-Javadoc)
	 * @see org.springframework.batch.item.validator.Validator#validate(java.lang.Object)
	 */
	@Override
	public void validate(T value) throws ValidationException {
		// TODO Auto-generated method stub
		Set<ConstraintViolation<T>> constraintViolations = validator.validate(value);
		if(constraintViolations.size() > 0) {
			StringBuilder message = new StringBuilder();
			for (ConstraintViolation<T> constraintViolation : constraintViolations) {
				message.append(constraintViolation.getMessage());
			}
			throw new ValidationException(message.toString());
			}
		}
}
