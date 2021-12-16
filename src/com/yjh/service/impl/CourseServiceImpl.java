/**
 * @no 3207130137
 * @author 叶嘉豪
 */
package com.yjh.service.impl;

import com.yjh.dao.ICourseDao;
import com.yjh.dao.impl.CourseDaoImpl;
import com.yjh.pojo.Course;
import com.yjh.service.ICourseService;

import java.util.List;

/**
 * 课程服务类实现类
 */
public class CourseServiceImpl implements ICourseService {
    //注入Dao层
    ICourseDao courseDao = new CourseDaoImpl();

    /**
     * 加载文件中的数据
     * @return
     */
    @Override
    public List<Course> loadCourse() {
        return courseDao.loadCourse();
    }
}
