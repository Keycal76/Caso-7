package Programa;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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
		//pruebaConDobleFor(prueba);
		ArrayList<String> letras= new ArrayList<String>();
		ArrayList<String> numeros= new ArrayList<String>();
		for(int i=0;i<26;i++){
			letras.add(Character.toString((char) 97+i));
		}
		for(int i=0;i<10;i++){
			numeros.add(Integer.toString(i));
		}
		boolean estar=true;
		while(estar) {
			System.out.println("¿Cuanta cantidad de sub grupos desea realizar?(2-10): ");
			String entradaTeclado="";
	        Scanner entradaEscaner=new Scanner (System.in);
	        entradaTeclado=entradaEscaner.nextLine ();
	        try {
		        if(Integer.parseInt(entradaTeclado)<=10 && Integer.parseInt(entradaTeclado)>=2){
		        	Grupos gruposDePrueba=new Grupos(letras,numeros,prueba,msj);
					gruposDePrueba.aproximarRespuesta(Integer.parseInt(entradaTeclado));
		        }else {
		        	System.out.println("Debe ser un número ente 2 y 10");
		        }
	        }catch (NumberFormatException e) {
	        	System.out.println("Debe ser un número");
	        }
		}
		//gruposDePrueba.imprimirGrupos();
	}
}