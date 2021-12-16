/**
 * @no 3207130137
 * @author 叶嘉豪
 */
package com.yjh.config;

import java.text.SimpleDateFormat;

/**
 * 系统常量
 */
public class Constants {

    //磁盘存储路径
    //课程文件存储路径
    public static final String COURSE_DATA_FILE_PATH = "src/com/yjh/data/course.txt";
    //学生信息文件存储路径
    public static final String TRANSCRIPT_DATA_FILE_PATH = "src/com/yjh/data/transcript.txt";
    //输出结果文件存储路径
    public static final String RESULT_DATA_FILE_PATH = "src/com/yjh/data/result.txt";

    //账号存储路径
    public static final String ACOUNT_DATA_FILE_PATH = "src/com/yjh//data/Acount.bin";

    //系统专用日期格式化器
    public static final SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");
}
