/**
 * @no 3207130137
 * @author 叶嘉豪
 */
package com.yjh.ui;

import com.yjh.controller.StudentController;
import com.yjh.pojo.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 添加信息菜单
 */
public class AddInfoMenu extends JFrame implements ActionListener {
    //标题
    JLabel jl = new JLabel("添加学生信息");

    //编号
    public JLabel studentId = new JLabel("学生编号");
    public JTextField studentIdText = new JTextField();
    //电话
    public JLabel name = new JLabel("学生姓名");
    public JTextField nameText = new JTextField();
    //名字
    public JLabel courseLabel1 = new JLabel("概率论");
    public JTextField courseText1 = new JTextField();
    public JLabel courseLabel2 = new JLabel("数据结构");
    public JTextField courseText2 = new JTextField();
    public JLabel courseLabel3 = new JLabel("R语言");
    public JTextField courseText3 = new JTextField();
    public JLabel courseLabel4 = new JLabel("程序设计");
    public JTextField courseText4 = new JTextField();
    public JLabel courseLabel5 = new JLabel("数据库原理");
    public JTextField courseText5 = new JTextField();
    public JLabel courseLabel6= new JLabel("线性代数");
    public JTextField courseText6 = new JTextField();
    public JLabel courseLabel7 = new JLabel("离散数学");
    public JTextField courseText7 = new JTextField();
    public JLabel courseLabel8 = new JLabel("大学英语");
    public JTextField courseText8 = new JTextField();
    public JLabel courseLabel9 = new JLabel("高等数据库");
    public JTextField courseText9 = new JTextField();
    public JLabel courseLabel10 = new JLabel("C语言");
    public JTextField courseText10 = new JTextField();
    public JLabel courseLabel11 = new JLabel("线性规划");
    public JTextField courseText11 = new JTextField();

    //按钮
    public JButton addBtn = new JButton("添加");
    public JButton clearBtn = new JButton("清空");
    public JButton cancelBtn = new JButton("取消");

    //注入控制层
    StudentController studentController = new StudentController();

    //初始化菜单
    public AddInfoMenu() {
        this.setTitle("添加员工信息");//标题
        this.setBounds(1000, 500, 300, 550);
        this.setLayout(null);

        jl.setBounds(100, 10, 80, 30);
        this.add(jl);
        //编号
        studentId.setBounds(50, 50, 80, 30);
        this.add(studentId);
        studentIdText.setBounds(115, 50, 100, 30);
        this.add(studentIdText);
        //姓名
        name.setBounds(50, 100, 80, 30);
        this.add(name);
        nameText.setBounds(115, 100, 100, 30);
        this.add(nameText);

        //各个成绩
        courseLabel1.setBounds(50, 150, 80, 30);
        this.add(courseLabel1);
        courseText1.setBounds(115, 150, 100, 30);
        this.add(courseText1);
        courseLabel2.setBounds(50, 175, 80, 30);
        this.add(courseLabel2);
        courseText2.setBounds(115, 175, 100, 30);
        this.add(courseText2);
        courseLabel3.setBounds(50, 200, 80, 30);
        this.add(courseLabel3);
        courseText3.setBounds(115, 200, 100, 30);
        this.add(courseText3);
        courseLabel4.setBounds(50, 225, 80, 30);
        this.add(courseLabel4);
        courseText4.setBounds(115, 225, 100, 30);
        this.add(courseText4);
        courseLabel5.setBounds(50, 250, 80, 30);
        this.add(courseLabel5);
        courseText5.setBounds(115, 250, 100, 30);
        this.add(courseText5);
        courseLabel6.setBounds(50, 275, 80, 30);
        this.add(courseLabel6);
        courseText6.setBounds(115, 275, 100, 30);
        this.add(courseText6);
        courseLabel7.setBounds(50, 300, 80, 30);
        this.add(courseLabel7);
        courseText7.setBounds(115, 300, 100, 30);
        this.add(courseText7);
        courseLabel8.setBounds(50, 325, 80, 30);
        this.add(courseLabel8);
        courseText8.setBounds(115, 325, 100, 30);
        this.add(courseText8);
        courseLabel9.setBounds(50, 350, 80, 30);
        this.add(courseLabel9);
        courseText9.setBounds(115, 350, 100, 30);
        this.add(courseText9);
        courseLabel10.setBounds(50, 375, 80, 30);
        this.add(courseLabel10);
        courseText10.setBounds(115, 375, 100, 30);
        this.add(courseText10);
        courseLabel11.setBounds(50, 400, 80, 30);
        this.add(courseLabel11);
        courseText11.setBounds(115, 400, 100, 30);
        this.add(courseText11);


        //按钮
        addBtn.setBounds(30, 450, 60, 30);
        addBtn.addActionListener(this);
        this.add(addBtn);
        clearBtn.setBounds(110, 450, 60, 30);
        clearBtn.addActionListener(this);
        this.add(clearBtn);
        cancelBtn.setBounds(190, 450, 60, 30);
        cancelBtn.addActionListener(this);
        this.add(cancelBtn);

        this.setResizable(false);//窗口不可变
        this.setVisible(true);
    }

    /**
     * 事件监听器
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==addBtn) {//添加按钮
//			new InfoAdder().addInfo();
            Student student = new Student();
            student.setStudentID(studentIdText.getText());
            student.setStudentName(nameText.getText());
            student.studentScore.put("103584",courseText1.getText());
            student.studentScore.put("154358",courseText2.getText());
            student.studentScore.put("166365",courseText3.getText());
            student.studentScore.put("245661",courseText4.getText());
            student.studentScore.put("251732",courseText5.getText());
            student.studentScore.put("284214",courseText6.getText());
            student.studentScore.put("396983",courseText7.getText());
            student.studentScore.put("411408",courseText8.getText());
            student.studentScore.put("514514",courseText9.getText());
            student.studentScore.put("563342",courseText10.getText());
            student.studentScore.put("735657",courseText11.getText());
            studentController.addStudent(student);
            JOptionPane.showMessageDialog(null,"添加成功！");

        }
        else if(e.getSource()==clearBtn) {//清空
            nameText.setText("");
            studentIdText.setText("");
            courseText1.setText("");
            courseText2.setText("");
            courseText3.setText("");
            courseText4.setText("");
            courseText5.setText("");
            courseText6.setText("");
            courseText7.setText("");
            courseText8.setText("");
            courseText9.setText("");
            courseText10.setText("");
            courseText11.setText("");
        }
        else if(e.getSource()==cancelBtn) {//取消
            this.setVisible(false);
        }

    }

//    //添加信息方法
//    public void addInfo() {
//        File file = new File(Constants.DATA_FILE_PATH);
//        //创建表存储对象
//
////		list.add(new EmployeeInfo(111, "02-98781999", "Williams", "Nick", "T", 35, "Computer Officer", "14-10-2000"));
////		list.add(new EmployeeInfo(112, "02-99893878", "Brown", "Sarah", "B", 12, "Electrician", "09-02-1992"));
//        InfoReader.list.add(new EmployeeInfo(Integer.parseInt(eNumberText.getText()),teleNumberText.getText(),
//                lastNameText.getText(),firstNameText.getText(),initialNameText.getText(),
//                Integer.parseInt(deNumberText.getText()),jobTitleText.getText(),dateText.getText()));
//        FunctionMenu.infoWindow.setText("");
//        for(EmployeeInfo i:InfoReader.list)
//            FunctionMenu.infoWindow.append(String.valueOf(i.toString2())+"\n");
//    }
}



////重写writeStreamHeader()
//class MyObjectOutputStream extends ObjectOutputStream{
//
//    public MyObjectOutputStream() throws IOException{
//        super();
//    }
//
//    public MyObjectOutputStream(OutputStream out) throws IOException {
//        super(out);
//    }
//
//    public void writeStreamHeader() throws IOException{
//        return;
//    }
//}