/**
 * @no 3207130137
 * @author 叶嘉豪
 */
package com.yjh.controller;

import com.yjh.pojo.Course;
import com.yjh.pojo.ResultInfo;
import com.yjh.pojo.Student;
import com.yjh.service.ICourseService;
import com.yjh.service.IStudentService;
import com.yjh.service.impl.CourseServiceImpl;
import com.yjh.service.impl.StudentServiceImpl;
import com.yjh.ui.FunctionMenu;

import java.util.*;

/**
 * 学生控制类
 */
public class StudentController {
    //注入service层
    IStudentService studentService = new StudentServiceImpl();
    ICourseService courseService = new CourseServiceImpl();

    /**
     * 打印所读入的科目和学生成绩列表，科目列表需依照科目代号的上升顺
     * 序排列，学生成绩的列表需依照学号的上升顺序排列，
     */
    public ResultInfo showStudentInfo(){
        ResultInfo resultInfo = new ResultInfo();
        Double average = 0.0;
        List<Student> studentList = studentService.loadStudent();
        //根据学号排序
        studentList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getStudentID().compareTo(o2.getStudentID());
            }
        });
        FunctionMenu.infoWindow.setText("");//显示区域清空
        FunctionMenu.infoWindow.append(String.format("%s\t%14s\t%3s\n", "学生编号","学生姓名","课程学分"));
        //遍历输出
        for (Student student : studentList) {
            average=0.0;
            Collection values = student.studentScore.values();
            Object[] array = values.toArray();
//            System.out.println(array[0]);
            for (int i = 0; i < array.length; i++) {
                average += Integer.valueOf(array[i].toString());
            }
            average/=array.length;
            String result = String.format("%.2f",average);
            FunctionMenu.infoWindow.append(student.toString()+"平均分:"+result+"\n");
        }
        return resultInfo;
    }


    /**
     * 依照学号顺序，对每一个科目列出所有修课学生的学号、姓名、和该科
     * 目的分数，并计算与打印该科目的平均分数。
     */
    public ResultInfo showCourseScore(){
        ResultInfo resultInfo = new ResultInfo();
        List<Student> studentList = studentService.loadStudent();
        //根据学号排序
        studentList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getStudentID().compareTo(o2.getStudentID());
            }
        });
        List<Course> courseList = courseService.loadCourse();
        Double average = 0.0;
        int length=0;
        FunctionMenu.infoWindow.setText("");//显示区域清空
        //处理数据//遍历每个科目
        for (Course course : courseList) {
            for (Student student : studentList) {
                average += Double.valueOf(student.studentScore.get(course.getCourseNo())+"");
                length++;
//                System.out.println(average);
            }
            average/=length;
            String result = String.format("%.2f",average);
            //计算平均分
            FunctionMenu.infoWindow.append("科目:"+course.getCourseName()+"\t平均分:"+result+"\n");
            //学生数据
            FunctionMenu.infoWindow.append(String.format("%s\t%12s\t%8s\n","学生学号","学生姓名","学生成绩"));
            for (Student student : studentList) {
                //屏幕上添加数据
                FunctionMenu.infoWindow.append(student.getStudentID()+"\t");
                FunctionMenu.infoWindow.append(student.getStudentName()+"\t\t");
                FunctionMenu.infoWindow.append(student.studentScore.get(course.getCourseNo())+"\n");
            }
            FunctionMenu.infoWindow.append("\n");
            //数据归0
            average = 0.0;
            length=0;
        }
        return resultInfo;
    }

    /**
     * 依照科目代号，对每一个科目列出最高分数和最低分数的学生学号和姓名
     */
    public ResultInfo showMaxAndMin(){
        ResultInfo resultInfo = new ResultInfo();
        List<Student> studentList = studentService.loadStudent();
        List<Course> courseList = courseService.loadCourse();
        courseList.sort(new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                return o1.getCourseNo().compareTo(o2.getCourseNo());
            }
        });
        Double max =0.0;//最大值
        Double min =Double.MAX_VALUE;//最小值
        String minName = null,minNo = null;
        String maxName = null,maxNo = null;
        FunctionMenu.infoWindow.setText("");//显示区域清空
        //处理数据//遍历每个科目
        for (Course course : courseList) {
            FunctionMenu.infoWindow.append("科目:"+course.getCourseName()+"\n");

            for (Student student : studentList) {
                if(max<Double.valueOf(student.studentScore.get(course.getCourseNo()) + "")){
                    max = Double.valueOf(student.studentScore.get(course.getCourseNo()) + "");
                    maxName=student.getStudentName();
                    maxNo=student.getStudentID();
                }
                if(min>Double.valueOf(student.studentScore.get(course.getCourseNo()) + "")){
                    min = Double.valueOf(student.studentScore.get(course.getCourseNo()) + "");
                    minName=student.getStudentName();
                    minNo=student.getStudentID();
                }
            }
            FunctionMenu.infoWindow.append("最高分:"+max+",学号:"+maxNo+",学生姓名:"+maxName+"\n");
            FunctionMenu.infoWindow.append("最低分:"+min+",学号:"+minNo+",学生姓名:"+minName+"\n");
            FunctionMenu.infoWindow.append("\n");
        }
        return resultInfo;
    }

    /**
     * 显示不及格
     */
    public ResultInfo showNoPass(){
        ResultInfo resultInfo = new ResultInfo();
        List<Student> studentList = studentService.loadStudent();
        //根据学号排序
        studentList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getStudentID().compareTo(o2.getStudentID());
            }
        });
        List<Course> courseList = courseService.loadCourse();
        FunctionMenu.infoWindow.setText("");//显示区域清空
        //处理数据//遍历每个科目
        for (Course course : courseList) {
            FunctionMenu.infoWindow.append("科目:"+course.getCourseName()+"\n");
            //打印学生信息
            for (Student student : studentList) {
                if(Double.valueOf(student.studentScore.get(course.getCourseNo())+"")<60){
                    FunctionMenu.infoWindow.append(
                            String.format(
                                    "学生姓名:%5s\t学生分数:%s\n",student.getStudentName(),Double.valueOf(student.studentScore.get(course.getCourseNo())+"")
                            ));
                }
            }
            FunctionMenu.infoWindow.append("\n");
        }
        return resultInfo;
    }

    /**
     * 根据ID查找学生
     * @param studentId
     * @return
     */
    public ResultInfo searchStudentByID(String studentId){
        ResultInfo resultInfo;
        List<Student> studentList = studentService.loadStudent();
        List<Course> courseList = courseService.loadCourse();
        FunctionMenu.infoWindow.setText("");//显示区域清空
        for (Student student : studentList) {
            if(student.getStudentID().equals(studentId)){
                FunctionMenu.infoWindow.append("学生编号:"+studentId+"\n"
                        +"学生姓名:"+student.getStudentName()+"\n"
                );
                for (Course course : courseList) {
                    FunctionMenu.infoWindow.append("科目:"+course.getCourseName()+"\n"
                            +"分数:"+student.studentScore.get(course.getCourseNo())+"\n"
                    );
                }
                resultInfo=new ResultInfo(200,"找到该学生","");
                return resultInfo;
            }
        }
        resultInfo= new ResultInfo(300,"找不到该学生","");
        return resultInfo;
    }

    /**
     * 根据名字查找学生
     * @param name
     * @return
     */
    public ResultInfo searchStudentByName(String name){
        ResultInfo resultInfo;
        List<Student> studentList = studentService.loadStudent();
        List<Course> courseList = courseService.loadCourse();
        FunctionMenu.infoWindow.setText("");//显示区域清空
        for (Student student : studentList) {
            if(student.getStudentName().equals(name)){
                FunctionMenu.infoWindow.append("学生编号:"+student.getStudentID()+"\n"
                        +"学生姓名:"+name+"\n"
                );
                for (Course course : courseList) {
                    FunctionMenu.infoWindow.append("科目:"+course.getCourseName()+"\n"
                            +"分数:"+student.studentScore.get(course.getCourseNo())+"\n"
                    );
                }
                resultInfo=new ResultInfo(200,"找到该学生","");
                return resultInfo;
            }
        }
        resultInfo= new ResultInfo(300,"找不到该学生","");
        return resultInfo;
    }

    /**
     * 添加学生
     * @param student
     * @return
     */
    public ResultInfo addStudent(Student student){
        ResultInfo resultInfo;
        int i = studentService.addStudent(student);
        if(i>0){
            resultInfo= new ResultInfo(200,"添加成功","");
            return resultInfo;
        }else {
            resultInfo= new ResultInfo(300,"添加失败","");
        }
        return resultInfo;
    }

    /**
     * 根据id删除学生
     * @param studentId
     * @return
     */
    public ResultInfo delStudentById(String studentId){
        ResultInfo resultInfo;
        int i = studentService.delStudentById(studentId);
        if(i>0){
            resultInfo= new ResultInfo(200,"添加成功","");
            return resultInfo;
        }else {
            resultInfo= new ResultInfo(300,"添加失败","");
        }
        return resultInfo;
    }

    /**
     * 将显示屏幕上的数据保存
     * @param info
     * @return
     */
    public ResultInfo saveInfo(String info){
//        System.out.println("保存");
//        System.out.println(info);
        ResultInfo resultInfo = new ResultInfo(300,"保存失败","");
        int i=studentService.saveInfo(info);
        if(i>0){
            resultInfo= new ResultInfo(200,"添加成功","");
            return resultInfo;
        }
        return resultInfo;
    }
}
