/**
 * @no 3207130137
 * @author 叶嘉豪
 */
package com.yjh.pojo;

import java.util.*;

/**
 * 学生类
 */
public class Student {
    /**
     * 学生id
     */
    private String studentID;

    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 学生成绩
     */
    public Map studentScore = new myHashMap<>();;

    /**
     * 读取文件生成成绩字符串
     * @param studentByStr
     * @return
     */
    public static Student parseStudentByStr(String studentByStr){
//        String[] sections = studentByStr.split("@|#| |\\$|\\{|\\}");
        String[] sections = studentByStr.split("@|#| |\\$");
//        for (int i = 0; i < sections.length; i++) {
//            String section = sections[i];
//            System.out.println(i+":"+section);
//            System.out.println(i);
//        }
        Student student = new Student();
        student.setStudentID(sections[1]);
        student.setStudentName(sections[2]);
//        student.studentScore = new myHashMap<>();
//        System.out.println(sections.length);
        for(int i=3;i<sections.length;i+=2){
//            System.out.println(i+":"+sections[i]+","+sections[i+1]);
            student.studentScore.put(sections[i],sections[i+1]);
        }
        return student;
    }

    /**
     * 将学生对象转成字符串存储
     */
    public static String parseStudentToStr(Student student){
//        String str = "@"+student.getStudentID()+" "+student.getStudentName()+"{";
        String str = "@"+student.getStudentID()+" "+student.getStudentName();
        Iterator<String> iter = student.studentScore.keySet().iterator();
        StringBuilder stringBuilder = new StringBuilder();
        while(iter.hasNext()){
            String key=iter.next();
            String value = student.studentScore.get(key).toString();
            stringBuilder.append("#"+key+" "+value);
        }
//        stringBuilder.append("}$");
        stringBuilder.append("$");
        str+=stringBuilder.toString();
        return str;
    }

    @Override
    public String toString() {
        String output = String.format("%s\t%6s\t%3s", studentID,studentName,studentScore);
        return output;
    }

    /**
     * 无参构造
     */
    public Student() {
    }

    /**
     * 半参构造
     * @param studentID
     */
    public Student(String studentID) {
        this.studentID = studentID;
    }

    /**
     * 全参构造方法
     * @param studentID
     * @param studentName
     */
    public Student(String studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null) return false;
        if(obj==this) return true;
        if(obj instanceof Student){
            Student otherStu = (Student)obj;
            return this.studentID.equals(otherStu.studentID);
        }
        return false;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}

//重写HashMap内部的toString方法
class myHashMap<K,T> extends HashMap<K,T> {
    @Override
    public String toString() {
        String ans = "";
        for (Map.Entry<K,T> entry : entrySet()) {
            ans += String.format("%s:%s\t", entry.getKey(),entry.getValue());
//            ans += "课程id:"+entry.getKey() + ",课程分数:" + entry.getValue() + " ";
        }
        return ans;
    }
}

//class MyComparator implements Comparator<String> {
//    @Override
//    public int compare(String o1, String o2) {
//        return o1.compareTo(o2);
//    }
//}