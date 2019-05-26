package vn.edu.vnua.dse.calendar.common;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public final class AppUtils {

	public static boolean isNullOrEmpty(String str) {
		if (str != null && !str.isEmpty())
			return false;
		return true;
	}

	
	public static boolean isNotNullOrEmpty(String str) {
		if (str != null && !str.isEmpty())
			return true;
		return false;
	}
	// Properties
	public static Properties MyProperties(String file) throws IOException {
		Resource resource = new ClassPathResource(file);
		InputStream resourceInputStream = resource.getInputStream();

			Properties prop = new Properties();
			// load a properties file
			prop.load(resourceInputStream);
			return prop;
	}
	
	public static String convertByteToHex(byte[] data) {
		  BigInteger number = new BigInteger(1, data);
		  String hashtext = number.toString(16);
		  // Now we need to zero pad it if you actually want the full 32 chars.
		  while (hashtext.length() < 32) {
		    hashtext = "0" + hashtext;
		  }
		  return hashtext;
		}
	
    public static String getMD5(String input) {
        try {
          MessageDigest md = MessageDigest.getInstance("MD5");
          byte[] messageDigest = md.digest(input.getBytes());
          return convertByteToHex(messageDigest);
        } catch (NoSuchAlgorithmException e) {
          throw new RuntimeException(e);
        }
      }
	
}
