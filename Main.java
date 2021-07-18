import java.util.Scanner;

public class Main {								
	public static void main(String[] args) {
		
		GenerateOTP OTP = new GenerateOTP();
		GenerateSmallPassword smallPassword = new GenerateSmallPassword();
		GenerateBigPassword bigPassword = new GenerateBigPassword();
		
		
		int otp_len = 6;
		int password_len = 3;
	
		System.out.println("login method- ");
		System.out.println("enter 1 for OTP and enter 2 for password ");
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		if(num==1) {
			System.out.println("your OTP is "+OTP.generateOTP(otp_len));
		}
		else if(num==2) {
			System.out.println("your password is "+(smallPassword.generatePassword(password_len)+bigPassword.generateOTP(password_len)));
		}
		else {
			System.out.println("invalid login attempt");
		}
	}

}
class GenerateOTP {								
	
	protected String str;						
	protected int str_len;								
	String OTP;											
	
	GenerateOTP() {								
		try {
			this.str = "0123456789";
			this.str_len = str.length();			
			this.OTP = "";
		}
		catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
//		finally {
//			System.out.println("check the input string in case of any errors, otherwise continue\n");
//		}
	}
	
	public String generateOTP(int len) {			
		
		for(int i=0;i<len;i++) {
			OTP = OTP + (str.charAt((int)((Math.random()*10)%str_len)));
		}
		return OTP;
	}
	
}
class GenerateSmallPassword extends GenerateOTP {	
	
	private String smallPassword;
	
	public GenerateSmallPassword() {
		this.str = "abcdefghijklmnopqrstuvwxyz";
		this.str_len = str.length();
		this.smallPassword = "";
	}
	
	public String generatePassword(int len) {
		
		for(int i=0;i<len;i++) {
			smallPassword = smallPassword + (str.charAt((int)((Math.random()*10)%str_len)));
		}
		return smallPassword;
	}
}
class GenerateBigPassword extends GenerateSmallPassword {
	
	private String bigPassword;
	
	public GenerateBigPassword() {
		this.str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		this.str_len = str.length();
		this.bigPassword = "";
	}
	
	public String generatePassword(int len) {
		
		for(int i=0;i<len;i++) {
			bigPassword = bigPassword + (str.charAt((int)((Math.random()*10)%str_len)));
		}
		return bigPassword;
	}
}
