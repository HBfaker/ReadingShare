package edu.bupt;

import edu.bupt.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	UserService userService;


	@Test
	public void contextLoads() {


		//userService.transactionTest();

//		User User = new User();
//		User.setId(1);
//		User.setUsername("xxxx");
//		User.setState(123);
//		userService.updateByPk(User);
	}

}
