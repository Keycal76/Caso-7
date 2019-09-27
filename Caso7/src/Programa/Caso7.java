package Programa;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class Caso7 {
	private static SecretKeySpec secretKey; 
	private static byte[] key;
	private static String msj;
	private static String myKey;
	
	 
	
	public static void pruebaConDobleFor(Criptado prueba) {
		String respuesta;
		for(int i=0;i<26;i++){
			String ascii = Character.toString((char) 97+i);
			for(int j=0;j<10;j++){
				prueba.setKey(prueba.setKey("29dh120"+ascii+"dk1"+Integer.toString(j)+"3"));
				respuesta=prueba.decrypt(msj);
				if(respuesta.equals("NULL")!=true) {
					System.out.println(ascii+"    "+Integer.toString(j)+"    "+"29dh120"+ascii+"dk1"+Integer.toString(j)+"3");
					System.out.println(prueba.decrypt(msj));
				}
			}
		}
	}
	
	public static void main(String[] args){
		msj="xZwM7BWIpSjYyGFr9rhpEa+cYVtACW7yQKmyN6OYSCv0ZEg9jWbc6lKzzCxRSSIvOvlimQZBMZOYnOwiA9yy3YU8zk4abFSItoW6Wj0ufQ0=";
		myKey="29dh120_dk1_3";
		Criptado prueba=new Criptado();
		pruebaConDobleFor(prueba);
		ArrayList<String> letras= new ArrayList<String>();
		ArrayList<String> numeros= new ArrayList<String>();
		for(int i=0;i<26;i++){
			letras.add(Character.toString((char) 97+i));
		}
		for(int i=0;i<10;i++){
			numeros.add(Integer.toString(i));
		}
		Grupos gruposDePrueba=new Grupos(letras,numeros,prueba,msj);
		gruposDePrueba.reducirGrupos(4);
		//gruposDePrueba.imprimirGrupos();
	}
}