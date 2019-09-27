package Programa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Grupos {
	private ArrayList<String> grupo1= new ArrayList<String>();
	private ArrayList<String> grupo2= new ArrayList<String>();
	Criptado prueba;
	ArrayList<SubGrupos> subGruposCorrectos= new ArrayList<SubGrupos>();
	String msj;
	
	public Grupos(ArrayList<String> pGrupo1, ArrayList<String> pGrupo2, Criptado pPrueba,String pMsj) {
		grupo1=pGrupo1;
		grupo2=pGrupo2;
		prueba=pPrueba;
		msj=pMsj;
	}
	
	public void imprimirGrupos() {
		for(int i=0;i<grupo1.size();i++) {
			System.out.println("Grupo 1 elemento "+Integer.toString(i+1)+": "+grupo1.get(i));
		}
		for(int i=0;i<grupo2.size();i++) {
			System.out.println("Grupo 2 elemento "+Integer.toString(i+1)+": "+grupo2.get(i));
		}
	}
	
	public ArrayList<SubGrupos> reducirGrupos(int cantSubGrupos){
		ArrayList<SubGrupos> subGrupos= new ArrayList<SubGrupos>();
		double tam1=((double)grupo1.size())/cantSubGrupos;
		double tam2=((double)grupo2.size())/cantSubGrupos;
		grupo1=desordenarArray(grupo1);
		grupo2=desordenarArray(grupo2);
		for(int i=0;i<cantSubGrupos;i++) {
			List<String> subGrupo1=grupo1.subList((int)(tam1*i),(int)(tam1*(i+1)));
			List<String> subGrupo2=grupo2.subList((int)(tam2*i),(int)(tam2*(i+1)));
			
			subGrupos.add(new SubGrupos(subGrupo1,subGrupo2,prueba,msj));
			subGrupos.get(i).busquedaExaustiva();
		}
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
