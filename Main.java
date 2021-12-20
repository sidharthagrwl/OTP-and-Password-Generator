package project;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter number to login: (1 - OTP / 2 - password)");
		int option = sc.nextInt();
		
		if(option == 1) {
			int len = 6;
			System.out.println("your OTP is " + getOTP(len));
			
		}else if(option == 2) {
			int lowerLen = 3, upperLen = 3;
			
			LowerCase pwd1 = new LowerCase();
			UpperCase pwd2 = new UpperCase();
			
			System.out.println("your password is " + pwd1.getPassword(lowerLen) + pwd2.getPassword(upperLen));
			
		}else {
			System.out.println("invalid input, pls check");
		}
	}
	
	static String getOTP(int len) {
		String str = "0123456789";
		
		String otp = "";
		for(int i=0;i<len;i++) {
			otp += str.charAt((int) (Math.random()*10));
		}
		return otp;
	}
	
}
class LowerCase {
	static String s;
	
	LowerCase() {
		s = "abcdefghijklmnopqrstuvwxyz";
	}
	
	static String getPassword(int lowerLen) {
		String lower = "";
		
		for(int i=0;i<lowerLen;i++) {
			lower += s.charAt((int) (Math.random()*10));
		}
		return lower;
	}
}
class UpperCase extends LowerCase {
	static String str;
	
	public UpperCase() {
		
		str = s.toUpperCase();
	}
	
	static String getPassword(int upperLen) {
		String upper = "";
		for(int i=0;i<upperLen;i++) {
			upper += str.charAt((int) (Math.random()*10));
		}
		return upper;
	}
}