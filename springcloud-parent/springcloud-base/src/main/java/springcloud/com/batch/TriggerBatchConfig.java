/**
 * 
 */package springcloud.com.batch;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.FlowJobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.validator.Validator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import springcloud.com.domain.Person;

/** 
* @author : 刘尊亮
* @date 创建时间：2019年3月1日 下午3:54:18 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * @author Administrator
 *
 */
 
/*@Configuration
@EnableBatchProcessing*/
public class TriggerBatchConfig {
	
	@Bean
	@StepScope
	public FlatFileItemReader<Person> reader(@Value("#{jobParameters['input.file.name']}") String pathTofile){
		 FlatFileItemReader<Person> reader = new FlatFileItemReader<>(); 
		 reader.setResource(new ClassPathResource(pathTofile)); 
		 reader.setLineMapper(new DefaultLineMapper<Person>() {{
			 setLineTokenizer(new DelimitedLineTokenizer() {{
				 setNames(new String[] {"name","age","nation","address"});
				 setDelimiter("#");
			 }});
			 setFieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {{
				 setTargetType(Person.class);
			 }});
		 }});
		 return reader;
	}

//	 @Bean
//	 public ItemReader<Person> reader(){
//		 FlatFileItemReader<Person> reader = new FlatFileItemReader<>();
//		 reader.setResource(new ClassPathResource("people.csv"));
//		 reader.setLineMapper(new DefaultLineMapper<Person>() {{
//			 setLineTokenizer(new DelimitedLineTokenizer() {{
//				 setNames(new String[] {"name","age","nation","address"});
//			 }});
//			 setFieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {{
//				 setTargetType(Person.class);
//			 }});
//		 }});
//		 return reader;
//	 }
	 
	 @Bean
	 public ItemProcessor<Person, Person> processor(){
		 CsvItemProcessor processor = new CsvItemProcessor();
		 processor.setValidator(CsvBeanValidator());
		 return processor;
	 }
	 
	 @Bean
	 public ItemWriter<Person> writer(DataSource dataSource){
		 JdbcBatchItemWriter<Person> writer = new JdbcBatchItemWriter<>();
		 
		 writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Person>());
		 
		 String sql = "insert into person"+"(id,name,age,nation,address)"+"values(null, :name ,:age, :nation, :address)";
		 writer.setSql(sql);
		 writer.setDataSource(dataSource);
		 return writer;
	 }
	 
	 @Bean
	 public JobRepository jobRepository(DataSource dataSource,PlatformTransactionManager transactionManager) throws Exception {
		 JobRepositoryFactoryBean jobRepositoryFactoryBean = new JobRepositoryFactoryBean();
		 jobRepositoryFactoryBean.setDataSource(dataSource);
		 jobRepositoryFactoryBean.setTransactionManager(transactionManager);
		 jobRepositoryFactoryBean.setDatabaseType("mysql");
		 return jobRepositoryFactoryBean.getObject();
	 }
	 
	 @Bean
	public SimpleJobLauncher jobLauncher(DataSource dataSource,PlatformTransactionManager transactionManager) throws Exception {
		SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
		jobLauncher.setJobRepository(jobRepository(dataSource, transactionManager));
		return jobLauncher;
	}
	 
	 @Bean
	 public Job importJob(JobBuilderFactory jobs ,Step s1) {
		  FlowJobBuilder listener = jobs.get("importJob")
				 .incrementer(new RunIdIncrementer())
				 .flow(s1).end().listener(csvJobListener());
		  Job build = listener.build();
		  return build;
	 }
	 
	 
	 @Bean
	 public Step step1(StepBuilderFactory stepBuilderFactory,ItemReader<Person> reader,ItemWriter<Person> writer,
			 ItemProcessor<Person, Person> processor) {
		 return stepBuilderFactory.get("step1")
		 .<Person,Person>chunk(3)
		 .reader(reader)
		 /*.listener(new WriteListener())*/
		 .processor(processor)
		 .writer(writer)
		 .build();
	 }
	 
	 @Bean
	 public CsvJobListener csvJobListener() {
		 return new CsvJobListener();
	 }
	 
	 @Bean
	 public Validator<Person> CsvBeanValidator(){
		 return new CsvBeanValidator<Person>();
	 }
}
