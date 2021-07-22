import java.util.Scanner;

public class OOPJProject {
    public static void main(String[] args) {
        
        GenerateOTP objOTP = new GenerateOTP();
        int otp_len = 6;
        int password_len = 3;

        System.out.println("choose login method ");
        Scanner sc = new Scanner(System.in);
        System.out.println("enter 1 for OTP and 2 for password ");
        int num = sc.nextInt();

        if(num==1) {
            System.out.println("your OTP is "+objOTP.getOTP(otp_len));
        }
        else if(num==2) {
            System.out.println("your password is ");
        }
        else {
            System.out.println("invalid login method");
        }
        sc.close();
    }
}
class GenerateOTP implements GeneratePassword {
    protected String str;
    protected int str_len;
    String OTP = " ";

    GenerateOTP() {
        this.str = "0123456789";
        this.str_len = str.length();
    }
    public String getOTP(int otp_len) {
        for(int i=0;i<otp_len;i++) {
            OTP = OTP + (str.charAt((int)((Math.random()*10)%str_len)));
        }
        return OTP;
    }

    @Override
    public String getPassword(int password_len) {
        
        return null;
    }
}
interface GeneratePassword {

    String getPassword(int password_len);
}