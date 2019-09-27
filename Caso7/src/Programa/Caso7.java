package Programa;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class Caso7 {
	private static SecretKeySpec secretKey; 
	private static byte[] key;
	
	public static SecretKeySpec setKey(String myKey){
		MessageDigest sha=null;
		try{
			key=myKey.getBytes("UTF-8");
			sha=MessageDigest.getInstance("SHA-1");
			key=sha.digest(key);
			key=Arrays.copyOf(key,16);
			secretKey=new SecretKeySpec(key,"AES");
			return secretKey;
		}
		catch(NoSuchAlgorithmException e){
			e.printStackTrace();  
			System.out.println("Error 1");
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
			System.out.println("Error 2");
		} 
		return null;
	} 
	
	
	public static void main(String[] args) throws Exception{
		String msj="xZwM7BWIpSjYyGFr9rhpEa+cYVtACW7yQKmyN6OYSCv0ZEg9jWbc6lKzzCxRSSIvOvlimQZBMZOYnOwiA9yy3YU8zk4abFSItoW6Wj0ufQ0=";
		String myKey="29dh120_dk1_3";
		Criptado prueba=new Criptado();
		for(int i=0;i<26;i++){
			String ascii = Character.toString((char) 97+i);
			for(int j=0;j<10;j++){
				System.out.println(ascii+"    "+Integer.toString(j)+"    "+"29dh120"+ascii+"dk1"+Integer.toString(j)+"3");
				prueba.setKey(setKey("29dh120"+ascii+"dk1"+Integer.toString(j)+"3"));
				System.out.println(prueba.decrypt(msj));
			}
		}
	}
}