package edu.bupt;

import edu.bupt.pojo.Book;
import edu.bupt.service.BookService;
import edu.bupt.service.UserService;
import edu.bupt.serviceImp.BookServiceImp;
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


	@Autowired
	BookServiceImp bookService;



	@Test
	public void contextLoads() {
		Book book = new Book();
		book.setUserId(2);
		book.setISBN("24456544");

		bookService.insert(book);

	}

}
