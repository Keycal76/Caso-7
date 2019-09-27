package Programa;

import java.util.ArrayList;

public class Grupos {
	private ArrayList<String> grupo1= new ArrayList<String>();
	private ArrayList<String> grupo2= new ArrayList<String>();
	
	public Grupos(ArrayList<String> pGrupo1, ArrayList<String> pGrupo2) {
		grupo1=pGrupo1;
		grupo2=pGrupo2;
	}
	
	public void imprimirGrupos() {
		for(int i=0;i<grupo1.size();i++) {
			System.out.println("Grupo 1 elemtento "+Integer.toString(i+1)+": "+grupo1.get(i));
		}
		for(int i=0;i<grupo2.size();i++) {
			System.out.println("Grupo 2 elemtento "+Integer.toString(i+1)+": "+grupo2.get(i));
		}
	}
}
