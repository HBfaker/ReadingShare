package edu.bupt.mapper;

import edu.bupt.pojo.Book;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 73681 on 2018/6/22.
 */
@Repository
public interface BookMapper extends BaseMapper<Book,Long> {

    /*
    * 根据条件查询
    * */
    public List<Book> selectByCondition(Map condition);
}
