package springcloud.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableAsync
@EnableHystrix
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class AsyncTaskComsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsyncTaskComsumerApplication.class, args);
	}
	
}
