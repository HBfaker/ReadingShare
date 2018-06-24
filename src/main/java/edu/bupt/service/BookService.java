package edu.bupt.service;

import edu.bupt.pojo.Book;

import java.util.List;
import java.util.Map;

/**
 * Created by 73681 on 2018/6/22.
 */
public interface BookService {
    /*
    * 得到用户的书籍
    * */
    public Book getUserBook(long pk);



    /*
    * 根据条件搜索书籍
    * */
    public List<Book> search(Map codition);
}
