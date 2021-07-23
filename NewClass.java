package package2;
import java.util.Scanner;

public class NewClass {

	public static void main(String[] args) {
		
		GenerateOTP objOTP = new GenerateOTP();
		GenerateLowerPassword objLpassword = new GenerateLowerPassword();
		GenerateUpperPassword objUpassword = new GenerateUpperPassword();
		
		int otp_len = 6;
		int password_len = 3;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("choose login method ");
		System.out.println("enter 1 for OTP and enter 2 for password- ");
		
		int num = sc.nextInt();
		if(num==1) {
			System.out.println("your OTP is "+objOTP.getOTP(otp_len));
		}
		else if(num==2) {
			System.out.println("your password is "+objLpassword.getLowerPassword(password_len)+objUpassword.getUpperPassword(password_len));
		}
		else {
			System.out.println("invalid login method");
		}
	}
}
class GenerateOTP {
	
	protected String str;
	protected int str_len;
	private String OTP = "";
	
	public GenerateOTP() {
		this.str = "0123456789";
		this.str_len = str.length();
	}
	
	public String getOTP(int len) {
	
		try {
		for(int i=0;i<len;i++) {
			OTP = OTP + (str.charAt((int)((Math.random()*10)%str_len)));
		}

	}
	catch(StringIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("exception caught \n");
		}
		return OTP;
}
}
class GenerateLowerPassword extends GenerateOTP implements LowerPassword{
	
	private String lower_password = "";
	
	public GenerateLowerPassword() {
		this.str = "abcdefghijklmnopqrstuvwxyz";
		this.str_len = str.length();
	}
	@Override
	public String getLowerPassword(int len) {
		
		for(int i=0;i<len;i++) {
			lower_password += (str.charAt((int)((Math.random()*10)%str_len)));
		}
		return lower_password;
	}
}
class GenerateUpperPassword extends GenerateOTP implements UpperPassword {

	private String upper_password = "";
	
	public GenerateUpperPassword() {
		this.str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		this.str_len = str.length();
	}
	@Override
	public String getUpperPassword(int len) {
		
		for(int i=0;i<len;i++) {
			upper_password += (str.charAt((int)((Math.random()*10)%str_len)));
		}
		return upper_password;
	}
}
interface LowerPassword {
	public String getLowerPassword(int len);
}
interface UpperPassword {
	public String getUpperPassword(int len);
}