import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import vn.edu.vnua.dse.calendar.ggcalendar.wrapperapi.APIWrapper;

public class Test{
	 public static void main(String[] args) throws IOException {

	        String token = "1/et5cnaJojCSkP-1gItP9HtKwYg693zPU4V3BwpKhrRw";
	        
	        APIWrapper apiWrapper = new APIWrapper();
	        
	        String accessToken = apiWrapper.getAccessToken();
	        System.out.println(accessToken);
	        
	        String email = apiWrapper.getEmailAddress("ya29.GlsQB5TEM0hW9XPAqvQq0J1tW8M7zf2Fg2ILgh6OP-dLab8-9KT49o4R5gwg3ZYwXUnr49Urzp1wBWrPCIzCosw20BlQF1UXFCASSuKXDSWK0dyZ5w8K_CO7klza");
	        
	        System.out.println(email);
	 }
}