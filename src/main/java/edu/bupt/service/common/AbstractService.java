package edu.bupt.service.common;

import edu.bupt.mapper.BaseMapper;

import java.io.Serializable;

/**
 * Created by 73681 on 2018/6/13.
 */
public abstract class AbstractService<T, ID extends Serializable> implements BaseService<T, ID>{
    @Override
    public abstract BaseMapper<T, ID> getMapper() ;

    @Override
    public int deleteByPrimaryKey(ID id) {
        return getMapper().deleteByPrimaryKey(id);
    }
    @Override
    public int insert(T record) {
        return getMapper().insert(record);
    }
    @Override
    public int insertSelective(T record) {
        return getMapper().insertSelective(record);
    }
    @Override
    public T selectByPrimaryKey(ID id) {
        return getMapper().selectByPrimaryKey(id);
    }
    @Override
    public int updateByPrimaryKeySelective(T record) {
        return getMapper().updateByPrimaryKeySelective(record);
    }
    @Override
    public int updateByPrimaryKeyWithBLOBs(T record) {
        return getMapper().updateByPrimaryKeyWithBLOBs(record);
    }
    @Override
    public int updateByPrimaryKey(T record) {
        return getMapper().updateByPrimaryKey(record);
    }
}
