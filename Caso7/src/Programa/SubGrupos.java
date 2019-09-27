package Programa;

import java.util.ArrayList;

public class SubGrupos {
	private ArrayList<String> grupo1= new ArrayList<String>();
	private ArrayList<String> grupo2= new ArrayList<String>();
	Criptado prueba;
	
	public SubGrupos(ArrayList<String> pGrupo1, ArrayList<String> pGrupo2, Criptado pPrueba) {
		grupo1=pGrupo1;
		grupo2=pGrupo2;
		prueba=pPrueba;
	}
}
