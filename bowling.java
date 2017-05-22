package main.java;

import java.util.Scanner;

public class BowlingGame {
	public  int getBowlingScore (String fps){

		String ctx =frams;
		String s_flie = null;
		String ex_tr = null;
		String[] sourceAndExtral = ctx.split("\\|"+"\\|");

		if (sourceAndExtral.length<2) {
			s_flie = sourceAndExtral[0];
			ex_tr = "00";
		}else{
			s_flie = sourceAndExtral[0];
			ex_tr = sourceAndExtral[1];
		}

		/**
		 * 将X全部替换为10 
		 */
		int[] extralInt = new int[2];
		for (int i = 0; i < ex_tr.length(); i++) {
			if (ex_tr.charAt(i)=='X') {
				extralInt[i] = 10;
			}else
				extralInt[i] = Integer.parseInt(ex_tr.charAt(i)+"");
		}

		/**
		 * 计算
		 */
		String[] fp = s_flie.split("\\|");
		int[] temp = new int[]{extralInt[0],extralInt[1]};//length-1的情况

		int res = 0;

		for (int i = fp.length-1; i >=0; i--) {
			/**
			 * 将额外进行赋值
			 */
			if (i==fp.length-2) {
				temp[1] = temp[0];
				temp[0] = parse(fp[i+1]);
			}else if(i<fp.length-2){

				if (fp[i+1].contains("-")) {
					if (fp[i+1].startsWith("-")) {
						temp[0] = 0;
						temp[1]	= parse(fp[i+1]);				
					}else if (fp[i+1].endsWith("-")) {
						temp[0]	= parse(fp[i+1]);				
						temp[1] = 0;
					}
				}else if(fp[i+1].contains("/")){
					temp[0] = parse(fp[i+1]);
					temp[1] = 10-parse(fp[i+1]);
				}else{
					temp[0] = parse(fp[i+1]);
					temp[1] = parse(fp[i+2]);
				}
			}

			if (fp[i].contains("X")) {
				int sum = 10+temp[0]+temp[1];
				System.out.println("10+temp[0]+temp[1]"+10+"+"+temp[0]+"+"+temp[1]);


				res+=sum;
			}
			if (fp[i].contains("/")) {
				int sum = 10+temp[0];
				System.out.println("10+temp[0]"+10+"+"+temp[0]);

				res+=sum;
			}
			if (fp[i].contains("-")) {
				System.out.println("+"+fp[i]);
				res+=parse(fp[i]);
			}
			System.out.println("res==="+res);
		}
		return res;
	
	}

	public  int parse(String str){
		int res = 0;
		if (str.contains("X")) {
			str = str.replace("X", "");
			res = 10;
			return res;
		}
		if (str.contains("-")) {
			str = str.replace("-", "");
		}
		if (str.contains("/")) {
			str = str.replace("/", "");
		}
		return Integer.parseInt(str);
	}
}
