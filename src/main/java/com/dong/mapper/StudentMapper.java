package com.dong.mapper;

import com.dong.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author songchao
 * @since 2021-06-30
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
