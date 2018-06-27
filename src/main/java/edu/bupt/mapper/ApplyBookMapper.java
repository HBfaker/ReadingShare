package edu.bupt.mapper;

import edu.bupt.pojo.ApplyBook;
import org.springframework.stereotype.Repository;

/**
 * Created by 73681 on 2018/6/26.
 */
@Repository
public interface ApplyBookMapper extends BaseMapper<ApplyBook,Long>{
    public ApplyBook selectByBookId(long bookId);
}
