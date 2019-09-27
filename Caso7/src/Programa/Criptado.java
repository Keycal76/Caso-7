package Programa;

import java.util.Base64;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.*;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class Criptado {
 
    private final static String alg = "AES";
    private final static String cI = "AES/CBC/PKCS5Padding";
    private static Key aesKey;
    
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
 
}