/**
 * 
 */package springcloud.com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/** 
* @author : 刘尊亮
* @date 创建时间：2019年2月25日 下午5:37:36 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * @author Administrator
 *
 */
 @Configuration
public class RedisConfig {

		@Bean
		public RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
		    RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
		    template.setConnectionFactory(jedisConnectionFactory);
		    template.setKeySerializer(new StringRedisSerializer());
		    template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		    //template.setHashKeySerializer(template.getKeySerializer());
		    //template.setHashValueSerializer(template.getValueSerializer());
		    return template;
		}

}
