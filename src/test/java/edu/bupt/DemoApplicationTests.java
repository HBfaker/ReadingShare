package edu.bupt;

import edu.bupt.mapper.UserMapper;
import edu.bupt.pojo.Book;
import edu.bupt.service.UserService;
import edu.bupt.serviceImp.BookServiceImp;
import edu.bupt.util.TokenUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	UserService userService;

	@Autowired
	BookServiceImp bookService;
	@Autowired
	UserMapper userMapper;

	private MockMvc mvc;
	@Autowired
	protected WebApplicationContext wac;

	@Before
	public void setup() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	@Test
	public void contextLoads() {
		Book book = new Book();
		book.setUserId(2);
		book.setISBN("24456544");

		bookService.insert(book);

	}

	//测试注册
	@Test
	public void testRegister() throws Exception{
		String responseString = mvc.perform(MockMvcRequestBuilders.post("/register")    //请求的url,请求的方法是POST
				.contentType(MediaType.APPLICATION_JSON)  //数据的格式
				.param("username","lisi") //添加参数
				.param("password", "123")
		).andExpect(status().isOk())    //返回的状态是200
			.andDo(print())         //打印出请求和相应的内容
			.andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串
		System.out.println("--------返回的json = " + responseString);
	}

	@Test
	public void testLogin() throws Exception{
		String responseString = mvc.perform(MockMvcRequestBuilders.post("/login")    //请求的url,请求的方法是POST
				.contentType(MediaType.APPLICATION_JSON)  //数据的格式
				.param("username","lisi") //添加参数
				.param("password", "123456")
		).andExpect(status().isOk())    //返回的状态是200
				.andDo(print())         //打印出请求和相应的内容
				.andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串
		System.out.println("--------返回的json = " + responseString);
	}

	@Test
	public void testUser() throws Exception{
//		User user = userMapper.selectByUsername("lisi");
//		User user = userMapper.selectByPrimaryKey(1);
//		System.out.println(user);
	}

	@Test
	public void testToken() throws Exception{
		String token = TokenUtil.createToken("zhangsan");
		String username = TokenUtil.getAppUsername(token);
		System.out.println("username:" + username);
	}

}
