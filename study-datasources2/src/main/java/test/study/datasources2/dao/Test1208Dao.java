package test.study.datasources2.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import test.study.datasources2.entity.Test1208;

/**
 * @author sunYang
 * @date 2022/1/7 16:52
 */
@Mapper
@DS("test0105")
public interface Test1208Dao extends BaseMapper<Test1208> {
}
