/**
 * @no 3207130137
 * @author 叶嘉豪
 */
package com.yjh.dao;

import com.yjh.pojo.Student;

import java.util.List;

/**
 * 学生Dao层
 */
public interface IStudentDao {
    /**
     * 加载文件中的数据
     * @return
     */
    List<Student> loadStudent();

    /**
     * 添加学生
     * @param student
     * @return
     */
    int addStudent(Student student);

    /**
     * 根据Id删除学生
     * @param studentId
     * @return
     */
    int delStudentById(String studentId);

    /**
     * 保存信息
     * @param info
     * @return
     */
    int saveInfo(String info);
}
