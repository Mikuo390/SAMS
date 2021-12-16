/**
 * @no 3207130137
 * @author 叶嘉豪
 */
package com.yjh.dao;

import com.yjh.pojo.Course;

import java.util.List;

/**
 * 课程DAO
 */
public interface ICourseDao {
    /**
     * 加载文件中的数据
     * @return
     */
    List<Course> loadCourse();
}
