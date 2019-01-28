package springcloud.com.service.feign;

import org.springframework.stereotype.Component;

import springcloud.com.domain.UserDO;


public class FeignFallback implements UserFeign{

	@Override
	public UserDO selectOne(String id) {
		// TODO Auto-generated method stub
		UserDO u = new UserDO();
		u.setAddress("出错了");
		u.setAge("17");
		return u;
	}

	/* (non-Javadoc)
	 * @see springcloud.com.serviceFeign.UserService#helloWord()
	 */
	@Override
	public String helloWord() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see springcloud.com.serviceFeign.UserService#nihao()
	 */
	@Override
	public String nihao() {
		// TODO Auto-generated method stub
		return null;
	}

}
