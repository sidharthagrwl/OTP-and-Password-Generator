import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter number to login: (1 - OTP / 2 - password)");
		int num = sc.nextInt();
		
		if(num == 1) {
			
			OTP otp = new OTP(6);
			
			System.out.println("your OTP is: " + otp.getOTP());
			
		} else if(num == 2) {
			int lowerlen = 3, upperlen = 3;
			
			LowerCase lc = new LowerCase();
			UpperCase uc = new UpperCase();
			
			System.out.println("your password is: " + lc.getPassword(lowerlen) + uc.getPassword(upperlen));
			
		} else {
			System.out.println("invalid input, pls check again");
			
		}

	}
	
}

class OTP {
	int len;
	
	OTP(int len) {
		this.len = len;
	}
	
	public String getOTP() {
		String str = "0123456789";
		String strotp = "";
		
		for(int i=0;i<this.len;i++) {
			strotp += str.charAt((int)(Math.random()*10));
		}
		
		return strotp;
	}
}

class LowerCase {
	 String s;
	 
	 LowerCase() {
		 s = "abcdefghijklmnopqrstuvwxyz";
	 }
	 
	public String getPassword(int lowerlen) {
		 String lower = "";
		 
		 for(int i=0;i<lowerlen;i++) {
			 lower += s.charAt((int) (Math.random()*10));
		 }
		 
		 return lower;
	 }
}

class UpperCase extends LowerCase {
	StringBuilder a = new StringBuilder(s.toUpperCase());
	
	public UpperCase() {
		
		a = a.reverse();
		
	}
	
	public String getPassword(int upperlen) {
		String upper = "";
		
		for(int i=0;i<upperlen;i++) {
			upper += a.charAt((int) (Math.random()*10));
		}
		
		return upper;
	}
}
