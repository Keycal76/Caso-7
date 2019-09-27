package Programa;

import java.util.ArrayList;
import java.util.Random;

public class Grupos {
	private ArrayList<String> grupo1= new ArrayList<String>();
	private ArrayList<String> grupo2= new ArrayList<String>();
	Criptado prueba;
	ArrayList<SubGrupos> subGruposCorrectos= new ArrayList<SubGrupos>();
	
	public Grupos(ArrayList<String> pGrupo1, ArrayList<String> pGrupo2, Criptado pPrueba) {
		grupo1=pGrupo1;
		grupo2=pGrupo2;
		prueba=pPrueba;
	}
	
	public void imprimirGrupos() {
		for(int i=0;i<grupo1.size();i++) {
			System.out.println("Grupo 1 elemento "+Integer.toString(i+1)+": "+grupo1.get(i));
		}
		for(int i=0;i<grupo2.size();i++) {
			System.out.println("Grupo 2 elemento "+Integer.toString(i+1)+": "+grupo2.get(i));
		}
	}
	
	public String[][] reducirGrupos(){
		ArrayList<SubGrupos> subGrupos= new ArrayList<SubGrupos>();
		//double tamano1=
		grupo1=desordenarArray(grupo1);
		grupo2=desordenarArray(grupo2);
		for(int i=0;i<4;i++) {
			//subGrupos.add(new SubGrupos(grupo1.subList(,),(grupo2.subList(,)));
		}
		int random1=(int) (Math.random() * grupo1.size()) + 1;
		int random2=(int) (Math.random() * grupo2.size()) + 1;
		return null;
	}
	
	public ArrayList<String> desordenarArray(ArrayList<String> array) {
		ArrayList arrDes = new ArrayList();
		Random randNum=new Random();
		while (array.size()>0){
			int i=(int) (Math.random()*array.size());
			arrDes.add(array.get(i));
			array.remove(i);
		}
		System.out.println(arrDes.toString());
		return arrDes;
	}
}
