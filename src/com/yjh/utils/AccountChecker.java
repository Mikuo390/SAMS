/**
 * @no 3207130137
 * @author 叶嘉豪
 */
package com.yjh.utils;

import com.yjh.pojo.Account;
import com.yjh.ui.LoginMenu;
import com.yjh.ui.RegisterMenu;

import javax.swing.*;

/**
 * 账号检测
 */
public class AccountChecker {
    public static void checkLoginText() {
        AccountFileWork.savefirst();
        AccountFileWork.readAccout();//读取账号数据
        boolean isContain = false;
        String LU = LoginMenu.userNameText.getText();
        String LP = LoginMenu.passwordText.getText();

        Account ac = new Account(LU,LP);
        for(int i=0;i<AccountFileWork.accountlist.size();i++) {

            if(ac.equals(AccountFileWork.accountlist.get(i))) {
                JOptionPane.showMessageDialog(null,"登录成功！");
                isContain = true;
//                new FunctionMenu();
                break;
            }
        }
        if(isContain == false) {
            JOptionPane.showMessageDialog(null,"账号或密码输入错误！");
            new LoginMenu();
        }
    }

    //获取注册账号
    public static void checkRegisterText() {
        AccountFileWork.savefirst();//第一次加载载入管理员账号
        AccountFileWork.readAccout();//读取账号数据
        boolean isRepeat = false;
        String RU = RegisterMenu.userNameText.getText();
        String RP = RegisterMenu.passwordText.getText();

        Account ac = new Account(RU,RP);

        for(int i=0;i<AccountFileWork.accountlist.size();i++) {
//			System.out.println(AccountFileWork.accountlist.get(i));
            if(ac.equals(AccountFileWork.accountlist.get(i))) {
//				System.out.println(AccountFileWork.accountlist.get(i));
                JOptionPane.showMessageDialog(null,"注册失败，账号重复！");
                isRepeat = true;
            }
            new RegisterMenu();
            break;
        }
        if(isRepeat == false) {
            AccountFileWork.accountlist.add(ac);//将账号数据装入列表
            AccountFileWork.saveAccout();//将列表数据填入文件
            JOptionPane.showMessageDialog(null,"注册成功！");
            new LoginMenu();
        }
    }
}
