package Programa;

import java.util.ArrayList;
import java.util.List;

public class SubGrupos {
	private List<String> grupo1= new ArrayList<String>();
	private List<String> grupo2= new ArrayList<String>();
	Criptado prueba;
	String msj;
	
	public SubGrupos(List<String> pGrupo1, List<String> pGrupo2, Criptado pPrueba, String pMsj) {
		grupo1=pGrupo1;
		grupo2=pGrupo2;
		prueba=pPrueba;
		msj=pMsj;
		System.out.println("Sub 1: "+grupo1.toString());
		System.out.println("Sub 2: "+grupo2.toString());
	}
	
	public int busquedaExaustiva() {
		int aciertos=0;
		String respuesta;
		for(int i=0;i<grupo1.size();i++){
			for(int j=0;j<grupo2.size();j++){
				prueba.setKey(prueba.setKey("29dh120"+grupo1.get(i)+"dk1"+grupo2.get(j)+"3"));
				respuesta=prueba.decrypt(msj);
				if(respuesta.equals("NULL")!=true) {
					aciertos+=1;
					System.out.println("UN ACIERTO");
				}
			}
		}
		return aciertos;
	}
}
