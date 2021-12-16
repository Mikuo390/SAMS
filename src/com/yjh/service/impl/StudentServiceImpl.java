/**
 * @no 3207130137
 * @author 叶嘉豪
 */
package com.yjh.service.impl;

import com.yjh.dao.IStudentDao;
import com.yjh.dao.impl.StudentDaoImpl;
import com.yjh.pojo.Student;
import com.yjh.service.IStudentService;

import java.util.List;

/**
 * 学生服务类实现类
 */
public class StudentServiceImpl implements IStudentService {
    //注入Dao层
    IStudentDao studentDao = new StudentDaoImpl();

    /**
     * 加载文件中的数据
     * @return
     */
    @Override
    public List<Student> loadStudent() {
        return studentDao.loadStudent();
    }

    /**
     * 添加学生
     * @param student
     * @return
     */
    @Override
    public int addStudent(Student student) {
        return studentDao.addStudent(student);
    }

    /**
     * 根据Id删除学生
     * @param studentID
     * @return
     */
    @Override
    public int delStudentById(String studentID) {
        return studentDao.delStudentById(studentID);
    }

    /**
     * 保存信息
     * @param info
     * @return
     */
    @Override
    public int saveInfo(String info) {
        return studentDao.saveInfo(info);
    }
}
