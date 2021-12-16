/**
 * @no 3207130137
 * @author 叶嘉豪
 */
package com.yjh.dao.impl;

import com.yjh.config.Constants;
import com.yjh.dao.IStudentDao;
import com.yjh.pojo.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 学生Dao层实现类
 */
public class StudentDaoImpl implements IStudentDao {
    /**
     * 加载文件中的数据
     * @return
     */
    @Override
    public List<Student> loadStudent() {
        BufferedReader reader = null;
        String studentInfoStr = null;
        List<Student> students = new ArrayList<>();
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(Constants.TRANSCRIPT_DATA_FILE_PATH)));

            while((studentInfoStr=reader.readLine())!=null)
                students.add(Student.parseStudentByStr(studentInfoStr));

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
        return students;
    }

    /**
     * 添加学生
     * @param student
     * @return
     */
    @Override
    public int addStudent(Student student) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileOutputStream(Constants.TRANSCRIPT_DATA_FILE_PATH,true));
            writer.println(Student.parseStudentToStr(student));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return 0;
        } finally {
            writer.flush();
            writer.close();
        }
        return 1;
    }

    /**
     * 根据Id删除学生
     * @param studentId
     * @return
     */
    @Override
    public int delStudentById(String studentId) {
        List<Student> students = this.loadStudent();
        students.remove(new Student(studentId));
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileOutputStream(Constants.TRANSCRIPT_DATA_FILE_PATH,false));
            for(Student student:students)
                writer.println(Student.parseStudentToStr(student));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return 0;
        } finally {
            writer.flush();
            writer.close();
        }
        return 1;
    }

    /**
     * 保存信息
     * @param info
     * @return
     */
    @Override
    public int saveInfo(String info) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileOutputStream(Constants.RESULT_DATA_FILE_PATH,true));
            writer.println(info);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return 0;
        } finally {
            writer.flush();
            writer.close();
        }
        return 1;
    }
}
