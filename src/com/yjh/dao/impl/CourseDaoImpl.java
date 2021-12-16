/**
 * @no 3207130137
 * @author 叶嘉豪
 */
package com.yjh.dao.impl;

import com.yjh.config.Constants;
import com.yjh.dao.ICourseDao;
import com.yjh.pojo.Course;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 课程Dao实现类
 */
public class CourseDaoImpl implements ICourseDao {

    @Override
    public List<Course> loadCourse() {
        BufferedReader reader = null;
        String courseInfoStr = null;
        List<Course> courses = new ArrayList<>();

        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(Constants.COURSE_DATA_FILE_PATH)));

            while((courseInfoStr=reader.readLine())!=null)
                courses.add(Course.parseCourseByStr(courseInfoStr));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return courses;
    }
}
