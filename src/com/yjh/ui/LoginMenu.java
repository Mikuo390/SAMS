/**
 * @no 3207130137
 * @author 叶嘉豪
 */
package com.yjh.ui;

import com.yjh.utils.AccountChecker;
import com.yjh.utils.VerificationCode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginMenu extends JFrame implements ActionListener {
    //用户名标签
    JLabel userName = new JLabel("用户名");
    public static JTextField userNameText = new JTextField();
    //密码标签
    JLabel password = new JLabel("密码");
    public static JPasswordField passwordText = new JPasswordField();
    //验证码标签
    JLabel VCode = new JLabel("验证码");
    JTextField VCodeText = new JTextField();
    String strvc = VerificationCode.generateVerificationCode();
    JLabel VC = new JLabel(strvc);

    public static String UN = new String();
    public static String PS = new String();

    //按钮
    JButton loginBtn = new JButton("登录");
    JButton registerBtn = new JButton("注册");
    JButton exitBtn = new JButton("退出");


    //初始化窗口
    public LoginMenu() {
        this.setTitle("SAMS——学生成绩管理系统");
        //设置布局
        this.setLayout(null);

        //用户名
        userName.setBounds(110, 50, 100, 20);
        this.add(userName);
        userNameText.setBounds(160, 50, 100, 20);
        this.add(userNameText);

        //密码
        password.setBounds(110, 90, 100, 20);
        this.add(password);
        passwordText.setBounds(160, 90, 100, 20);
        this.add(passwordText);

        //验证码
        VCode.setBounds(110, 130, 100, 20);
        this.add(VCode);
        VCodeText.setBounds(160, 130, 50, 20);
        this.add(VCodeText);
        VC.setBounds(220, 130, 40, 20);
        VC.setBorder(BorderFactory.createEtchedBorder());
        this.add(VC);
//		System.out.println(strvc);

        //按钮
        loginBtn.addActionListener(this);
        loginBtn.setBounds(50, 180, 75, 20);
        this.add(loginBtn);
        registerBtn.addActionListener(this);
        registerBtn.setBounds(150, 180, 75, 20);
        this.add(registerBtn);
        exitBtn.addActionListener(this);
        exitBtn.setBounds(250, 180, 75, 20);
        this.add(exitBtn);

        //外部框架设置
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);//窗口不可变
        this.setBounds(1100,500,400,300);
        this.setVisible(true);
    }

    /**
     * 事件监听器
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==loginBtn) {//登录
            String name = userNameText.getText();
            UN = name;
            String psw = passwordText.getText();
            PS = psw;
            String vc = VCodeText.getText();
            //未输入弹窗提示
            if(name.length()==0 && name.length()==0)
                JOptionPane.showMessageDialog(null,"请输入用户名和密码！");
            else if(name.length()==0 && psw.length()!=0)
                JOptionPane.showMessageDialog(null,"请输入用户名！");
            else if(name.length()!=0 && psw.length()==0)
                JOptionPane.showMessageDialog(null,"请输入密码！");
            else if(name.length()!=0 && psw.length()!=0 && vc.length()==0)
                JOptionPane.showMessageDialog(null,"请输入验证码！");
            else {
                //账号密码设置
                if(!vc.equals(strvc)) {
                    JOptionPane.showMessageDialog(null,"验证码错误！");
                }else if(vc.equals(strvc)) {
                    //检测账号数据
                    AccountChecker.checkLoginText();
//					JOptionPane.showMessageDialog(null,"登录成功！");
                    this.setVisible(false);
					new FunctionMenu();
                }
            }


        }
        else if(e.getSource()==registerBtn) {//注册
            this.setVisible(false);
            new RegisterMenu();

        }
        else if(e.getSource()==exitBtn) {//退出
            new ExitMenu();
        }

    }

}
