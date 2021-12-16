/**
 * @no 3207130137
 * @author 叶嘉豪
 */
package com.yjh.ui;

import com.yjh.controller.StudentController;
import com.yjh.pojo.ResultInfo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 删除学生信息菜单
 */
public class DeleteMenu extends JFrame implements ActionListener {

    //页面元素
    JLabel jl = new JLabel("删除学生信息");
    JLabel studentId = new JLabel("学生编号");
    JTextField idText = new JTextField();
    JButton delBtn = new JButton("删除");
    JButton resetBtn = new JButton("重置");
    JButton exitBtn = new JButton("退出");

    //注入控制层
    StudentController studentController = new StudentController();

    //页面初始化
    public DeleteMenu() {
        this.setLayout(null);
        setTitle("删除学生信息");
        setBounds(1000, 500, 400, 300);

        jl.setBounds(140,50, 150, 30);
        this.add(jl);
        studentId.setBounds(110,100, 150, 30);
        this.add(studentId);
        idText.setBounds(170,100, 100, 30);
        this.add(idText);

        delBtn.setBounds(40, 180, 80, 30);
        delBtn.addActionListener(this);
        this.add(delBtn);
        resetBtn.setBounds(150, 180, 80, 30);
        resetBtn.addActionListener(this);
        this.add(resetBtn);
        exitBtn.setBounds(260, 180, 80, 30);
        exitBtn.addActionListener(this);
        this.add(exitBtn);

        setVisible(true);
    }

    /**
     * 事件监听器
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String studentId = idText.getText();
        boolean isFind = false;
        if(e.getSource() == delBtn) {//删除事件
            if("".equals(studentId)){
                JOptionPane.showMessageDialog(null, "id不能为空！");
            }else{
                ResultInfo resultInfo = studentController.delStudentById(studentId);
                if(resultInfo.getCode()==200){
                    isFind=true;
                }
                if(isFind==false) {
                    JOptionPane.showMessageDialog(null, "没有找到该学生！");
                }else if(isFind==true){
                    JOptionPane.showMessageDialog(null, "删除成功！");
                }
            }
        }
        else if(e.getSource() == resetBtn) {
            idText.setText(null);
        }
        else if(e.getSource() == exitBtn) {
            this.setVisible(false);
        }

    }

}

