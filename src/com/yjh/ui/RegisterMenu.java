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

/**
 * 注册菜单
 */
public class RegisterMenu extends JFrame implements ActionListener {
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

    //注册退出
    JButton registerBtn = new JButton("注册");
    JButton cancelBtn = new JButton("取消");
    JButton exitBtn = new JButton("退出");

    //初始化菜单
    public RegisterMenu() {
        this.setTitle("SAMS——注册界面");
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

        //按钮
        registerBtn.addActionListener(this);
        registerBtn.setBounds(50, 180, 75, 20);
        this.add(registerBtn);
        cancelBtn.addActionListener(this);
        cancelBtn.setBounds(150, 180, 75, 20);
        this.add(cancelBtn);
        exitBtn.addActionListener(this);
        exitBtn.setBounds(250, 180, 75, 20);
        this.add(exitBtn);

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

        if(e.getSource()==registerBtn) {//登录
            String name = userNameText.getText();
            String psw = passwordText.getText();
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
                }
                else if(vc.equals(strvc)) {

                    //注册号码检测
                    AccountChecker.checkRegisterText();

//					JOptionPane.showMessageDialog(null,"注册成功！");
                    this.setVisible(false);
//					new LoginMenu();
                }
            }
        }
        else if(e.getSource()==cancelBtn) {//取消
            this.setVisible(false);
            new LoginMenu();
        }
        else if(e.getSource()==exitBtn) {//退出
            new ExitMenu();
        }
    }
}
