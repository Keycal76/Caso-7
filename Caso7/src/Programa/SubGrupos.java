package Programa;

import java.util.ArrayList;
import java.util.List;

public class SubGrupos {
	private List<String> grupo1= new ArrayList<String>();
	private List<String> grupo2= new ArrayList<String>();
	Criptado prueba;
	
	public SubGrupos(List<String> pGrupo1, List<String> pGrupo2, Criptado pPrueba) {
		grupo1=pGrupo1;
		grupo2=pGrupo2;
		prueba=pPrueba;
		System.out.println("Sub 1: "+grupo1.toString());
		System.out.println("Sub 2: "+grupo2.toString());
	}
}
