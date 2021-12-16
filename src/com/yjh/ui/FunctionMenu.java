/**
 * @no 3207130137
 * @author 叶嘉豪
 */
package com.yjh.ui;

import com.yjh.controller.CourseController;
import com.yjh.controller.StudentController;
import com.yjh.pojo.ResultInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 功能菜单
 */
public class FunctionMenu extends JFrame implements ActionListener {

    //欢迎语
    JLabel tip1 = new JLabel("欢迎使用信息管理系统");
    JLabel tip2 = new JLabel("单击按钮选择功能");
    JLabel tip3 = new JLabel("鼠标悬浮可查看详细介绍");

    //右上角的用户名
    JButton userNameBtn = new JButton("用户名:"+LoginMenu.UN);
    //说明按钮
    JButton InstructionBtn = new JButton("说明");
    JButton exitBtn = new JButton("退出");

    //时钟
    Timer timer = new Timer();
    JLabel clockJL = new JLabel();
    Date clockDate = new Date();

    //功能按钮
    JButton btn1 = new JButton("显示课程");
    JButton btn2 = new JButton("显示成绩");
    JButton btn3 = new JButton("依照科目");
    JButton btn4 = new JButton("最高低分");
    JButton btn5 = new JButton("不及格");
    JButton btn6 = new JButton("查找");
    JButton btn7 = new JButton("添加");
    JButton btn8 = new JButton("删除");
    JButton btn9 = new JButton("保存");

    //信息显示窗口
    public static JTextArea infoWindow = new JTextArea();
    //滚动条
    JScrollPane jinfoWindow = new JScrollPane(infoWindow);

    //注入Controller层
    CourseController courseController = new CourseController();
    StudentController studentController = new StudentController();

    //初始化菜单
    public FunctionMenu() {
//        InfoReader.readInfo();//创建菜单直接读取文件

        this.setTitle("SAMS——学生成绩管理系统功能界面");
        //设置布局
        this.setLayout(null);

        //欢迎语布局
        tip1.setBounds(36, 10, 500, 20);
//		tip1.setBorder(BorderFactory.createEtchedBorder());
        this.add(tip1);
        tip2.setBounds(40, 30, 500, 20);
        this.add(tip2);
        tip3.setBounds(35, 50, 500, 20);
        this.add(tip3);

        //上方信息按钮
        userNameBtn.setBounds(1173, 10, 200, 20);
        userNameBtn.addActionListener(this);
        this.add(userNameBtn);
        InstructionBtn.setBounds(1400, 10, 80, 20);
        this.add(InstructionBtn);
        exitBtn.setBounds(1500, 10, 80, 20);
        exitBtn.addActionListener(this);
        this.add(exitBtn);

        //信息显示窗口
//		infoWindow.setBounds(200, 100, 1300, 700);
//		this.add(infoWindow);
        infoWindow.setFont(new Font("宋体", Font.BOLD,20));
        infoWindow.setFocusable(false);
        jinfoWindow.setBounds(200, 100, 1300, 700);
        this.add(jinfoWindow);

        //时钟信息
        timer.scheduleAtFixedRate(new TimerTask(){
            public void run() {
                SimpleDateFormat clockSDF = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
//				SimpleDateFormat clockSDF = new SimpleDateFormat("yyyy年MM月dd日");
                String format =  clockSDF.format(clockDate);
                clockJL.setText(format);
//				repaint();
            }
        },clockDate,1000);
        this.add(clockJL);
        clockJL.setFont(new Font("宋体", Font.BOLD,30));
        clockJL.setBorder(BorderFactory.createTitledBorder("当前时间"));
        clockJL.setBounds(500, 25, 400, 50);

        //功能按钮
        btn1.setBounds(50, 100, 100, 50);
        btn1.setToolTipText("打印科目");
        btn1.addActionListener(this);
        this.add(btn1);

        btn2.setBounds(50, 175, 100, 50);
        btn2.setToolTipText("打印所读入的科目和学生成绩列表");
        btn2.addActionListener(this);
        this.add(btn2);

        btn3.setBounds(50, 250, 100, 50);
        btn3.setToolTipText("依照学号顺序，对每一个科目列出所有修课学生的学号、姓名、和该科目的分数，并计算与打印该科目的平均分数。");
        btn3.addActionListener(this);
        this.add(btn3);

        btn4.setBounds(50, 325, 100, 50);
        btn4.setToolTipText("依照科目代号，对每一个科目列出最高分数和最低分数的学生学号和姓名");
        btn4.addActionListener(this);
        this.add(btn4);

        btn5.setBounds(50, 400, 100, 50);
        btn5.setToolTipText("依照学号顺序列出有不及格科目的学生和该学生的不及格科目与分数");
        btn5.addActionListener(this);
        this.add(btn5);

        btn6.setBounds(50, 475, 100, 50);
        btn6.setToolTipText("搜索和显示特定学生信息");
        btn6.addActionListener(this);
        this.add(btn6);

        btn7.setBounds(50, 550, 100, 50);
        btn7.setToolTipText("删除在本地文件的信息");
        btn7.addActionListener(this);
        this.add(btn7);

        btn8.setBounds(50, 625, 100, 50);
        btn8.setToolTipText("在本地文件中保存");
        btn8.addActionListener(this);
        this.add(btn8);

        btn9.setBounds(50, 700, 100, 50);
        btn9.setToolTipText("待添加");
        btn9.addActionListener(this);
        this.add(btn9);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置可关闭窗口
        this.setResizable(false);//窗口不可变
        this.setBounds(500,300,1600,900);
        this.setVisible(true);
    }

    /**
     * 事件监听器
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==userNameBtn) {//用户中心
            new UserMenu();
        }
        else if(e.getSource()==InstructionBtn) {//说明

        }
        else if(e.getSource()==exitBtn) {//离开按钮
            new ExitMenu();
        }
        else if(e.getSource()==btn1) {
            courseController.showCourseInfo();
        }
        else if(e.getSource()==btn2) {
            studentController.showStudentInfo();
        }
        else if(e.getSource()==btn3) {
            studentController.showCourseScore();
        }
        else if(e.getSource()==btn4) {
            studentController.showMaxAndMin();
        }
        else if(e.getSource()==btn5) {
            studentController.showNoPass();
        }
        else if(e.getSource()==btn6) {
            new SearchInfoMenu();
        }
        else if(e.getSource()==btn7) {
            new AddInfoMenu();
        }
        else if(e.getSource()==btn8) {
            new DeleteMenu();
        }
        else if(e.getSource()==btn9) {
            ResultInfo resultInfo = studentController.saveInfo(infoWindow.getText());
            if(resultInfo.getCode().equals(200)){
                JOptionPane.showMessageDialog(null, "保存成功!");
            }else{
                JOptionPane.showMessageDialog(null, "保存失败!");
            }
        }
    }
}

