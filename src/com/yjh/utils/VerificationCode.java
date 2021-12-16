/**
 * @no 3207130137
 * @author 叶嘉豪
 */
package com.yjh.utils;

import java.util.Random;

/**
 * 验证码生成器
 */
public class VerificationCode {

    //验证码生成器
    public static String generateVerificationCode() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<4;i++) {
            Integer num = rand.nextInt(10);
//			System.out.println(num);
            sb.append(String.valueOf(num));
        }
        String s = sb.toString();
        return s;
    }

//	public static void main(String[] args) {
//		VerificationCode.generateVerificationCode();
//	}

}
