/**
 * @no 3207130137
 * @author 叶嘉豪
 */
package com.yjh.ui;

import com.yjh.controller.CourseController;
import com.yjh.controller.StudentController;
import com.yjh.pojo.ResultInfo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 搜索菜单
 */
public class SearchInfoMenu extends JFrame implements ActionListener {

    //组件
    JLabel jl = new JLabel("搜寻学生信息");
    JLabel tip = new JLabel("请选择搜索类型");

    JComboBox jb = new JComboBox();
    JTextField searchText = new JTextField();

    JButton searchBtn = new JButton("搜索");
    JButton cancelBtn = new JButton("取消");

    //页面初始化
    public SearchInfoMenu() {
        this.setTitle("搜素信息");
        this.setBounds(1000, 500, 300, 400);
        this.setLayout(null);

        this.add(jl);
        jl.setBounds(100, 50, 150, 30);
        this.add(tip);
        tip.setBounds(90, 100, 150, 30);

        //选择框
        this.add(jb);
        jb.setBounds(70, 150, 150, 30);
        jb.addItem("——<请选择>——");
        jb.addItem("学生编号");
        jb.addItem("学生姓名");
        this.add(searchText);
        searchText.setBounds(70, 200, 150, 30);

        //按钮
        this.add(searchBtn);
        searchBtn.setBounds(50, 270, 80, 30);
        searchBtn.addActionListener(this);
        this.add(cancelBtn);
        cancelBtn.setBounds(160, 270, 80, 30);
        cancelBtn.addActionListener(this);

        this.setVisible(true);
    }

    //注入Controller层
    CourseController courseController = new CourseController();
    StudentController studentController = new StudentController();

    /**
     * 页面监听器
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==searchBtn) {//点击搜索
            boolean isFind = false;

            if(jb.getSelectedItem()=="学生编号") {
                ResultInfo resultInfo = studentController.searchStudentByID(searchText.getText());
                if(resultInfo.getCode()==200){
                    isFind = true;
                }
            }
            else if(jb.getSelectedItem()=="学生姓名") {
                ResultInfo resultInfo = studentController.searchStudentByName(searchText.getText());
                if(resultInfo.getCode()==200){
                    isFind = true;
                }
            }
            if(isFind==false) {
                JOptionPane.showMessageDialog(null, "未找到该学生");
            }
            else if(isFind==true) {
                JOptionPane.showMessageDialog(null, "已找到该学生");
            }

        }
        else if(e.getSource()==cancelBtn) {
            this.setVisible(false);
        }

    }
}

