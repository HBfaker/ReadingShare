package edu.bupt.serviceImp;

import edu.bupt.mapper.BaseMapper;
import edu.bupt.mapper.BookMapper;
import edu.bupt.pojo.Book;
import edu.bupt.service.BookService;
import edu.bupt.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by 73681 on 2018/6/22.
 */
@Service
public class BookServiceImp extends AbstractService<Book,Long> implements BookService{

    @Autowired
    BookMapper bookMapper;

    @Override
    public BaseMapper getMapper() {
        return bookMapper;
    }


    @Override
    public Book getUserBook(long pk) {
        return bookMapper.selectByPrimaryKey(pk);
    }

    @Override
    public List<Book> search(Map codition) {
        return bookMapper.selectByCondition(codition);
    }
}
