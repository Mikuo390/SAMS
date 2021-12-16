/**
 * @no 3207130137
 * @author 叶嘉豪
 */
package com.yjh.pojo;

/**
 * 课程科目类
 */
public class Course {

    /**
     * 科目编号
     */
    private String courseNo;

    /**
     * 科目名字
     */
    private String courseName;

    /**
     * 学分
     */
    private int creditHours;

    @Override
    public String toString() {
        String output = String.format("%s\t%13s\t%3s", courseNo,courseName,creditHours);
        return output;
    }

    /**
     * 读取文件生成课程字符串
     * @param courseInfoStr
     * @return
     */
    public static Course parseCourseByStr(String courseInfoStr){
        String[] sections = courseInfoStr.split("\\ ");
        Course course = new Course();
        course.setCourseNo(sections[0]);
        course.setCourseName(sections[1]);
        course.setCreditHours(Integer.valueOf(sections[2]));
        return course;
    }

    /**
     * 无参构造方法
     */
    public Course() {
    }

    /**
     * 全参构造方法
     * @param courseNo
     * @param courseName
     * @param creditHours
     */
    public Course(String courseNo, String courseName, int creditHours) {
        this.courseNo = courseNo;
        this.courseName = courseName;
        this.creditHours = creditHours;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }
}
