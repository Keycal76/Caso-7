package Programa;

import java.util.Arrays;
import java.util.Base64;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.*;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptado {
 
    private final static String alg = "AES";
    private final static String cI = "AES/CBC/PKCS5Padding";
    private static Key aesKey;
    private static byte[] key;
    private static SecretKeySpec secretKey;
    
    public Criptado() {
    	
    }
    
    public void setKey(SecretKeySpec pKey) {
    	aesKey=pKey;
    }
    
    public String encript(String text) throws Exception {
     
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, aesKey);
     
        byte[] encrypted = cipher.doFinal(text.getBytes());
             
        return new String(Base64.getEncoder().encode(encrypted));
        }
     
    public String decrypt(String encrypted){
        byte[] encryptedBytes=Base64.getDecoder().decode(encrypted.replace("\n", "") );
     
        Cipher cipher;
		try {
			cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, aesKey);
			String decrypted = new String(cipher.doFinal(encryptedBytes));
			return decrypted;
		}catch (NoSuchAlgorithmException e) {
		}catch (NoSuchPaddingException e) {
		}catch (IllegalBlockSizeException e) {
		}catch (BadPaddingException e) {
		}catch (InvalidKeyException e) {
		}
             
        return "NULL";
        }
    
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
}