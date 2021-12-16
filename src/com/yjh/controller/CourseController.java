/**
 * @no 3207130137
 * @author 叶嘉豪
 */
package com.yjh.controller;

import com.yjh.pojo.Course;
import com.yjh.service.ICourseService;
import com.yjh.service.impl.CourseServiceImpl;
import com.yjh.ui.FunctionMenu;

import java.util.Comparator;
import java.util.List;

/**
 * 课程类控制器
 */
public class CourseController {

    //注入service层
    ICourseService courseService = new CourseServiceImpl();

    /**
     * 显示课程信息
     */
    public void showCourseInfo(){
        List<Course> courseList = courseService.loadCourse();
        //根据学号排序
        courseList.sort(new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                return o1.getCourseNo().compareTo(o2.getCourseNo());
            }
        });
        FunctionMenu.infoWindow.setText("");//显示区域清空
        FunctionMenu.infoWindow.append(String.format("%s\t%13s\t%3s\n", "课程编号","课程名称","课程学时"));
        for (Course course : courseList) {
//            System.out.println(course);
            FunctionMenu.infoWindow.append(course.toString()+"\n");
        }
    }
}
