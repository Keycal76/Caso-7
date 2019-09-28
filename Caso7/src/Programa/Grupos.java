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
		grupo1=new ArrayList<String>(pGrupo1);
		grupo2=new ArrayList<String>(pGrupo2);
		prueba=pPrueba;
		msj=pMsj;
	}
	
	public List[] aproximarRespuesta(int cantSubGrupos) {
		int r=0;
		while(subGruposCorrectos.size()<cantSubGrupos) {
			reducirGrupos(cantSubGrupos);
			r++;
		}
		//System.out.println("Final de busqueda "+subGruposCorrectos.size()+" "+r);
		List<String> coincidencias1=subGruposCorrectos.get(0).grupo1;
		List<String> coincidencias2=subGruposCorrectos.get(0).grupo2;
		List<String> temp=new ArrayList<String>();
		for(int i=1;i<subGruposCorrectos.size();i++) {
			//System.out.println("Proceso 1: "+coincidencias1.toString()+"||"+subGruposCorrectos.get(i).grupo1.toString());
			//System.out.println("Proceso 2: "+coincidencias2.toString()+"||"+subGruposCorrectos.get(i).grupo2.toString());
			for(int j=0;j<subGruposCorrectos.get(i).grupo1.size();j++) {
				for(int k=0;k<coincidencias1.size();k++) {
					if(subGruposCorrectos.get(i).grupo1.get(j).equals(coincidencias1.get(k))) {
						temp.add(subGruposCorrectos.get(i).grupo1.get(j));
					}
				}
			}
			if(temp.size()!=0) {
				coincidencias1=new ArrayList<String>(temp);
				temp.clear();
			}
			
			for(int j=0;j<subGruposCorrectos.get(i).grupo2.size();j++) {
				for(int k=0;k<coincidencias2.size();k++) {
					if(subGruposCorrectos.get(i).grupo2.get(j).equals(coincidencias2.get(k))) {
						temp.add(subGruposCorrectos.get(i).grupo2.get(j));
					}
				}
			}
			if(temp.size()!=0) {
				coincidencias2=new ArrayList<String>(temp);
				temp.clear();
			}
		}
		
		//System.out.println("FINAL 1: "+coincidencias1.toString());
		//System.out.println("FINAL 2: "+coincidencias2.toString());
		return new List[] {coincidencias1,coincidencias2};
	}
	
	public void reducirGrupos(int cantSubGrupos){
		double tam1=((double)grupo1.size())/cantSubGrupos;
		double tam2=((double)grupo2.size())/cantSubGrupos;
		grupo1=desordenarArray(grupo1);
		grupo2=desordenarArray(grupo2);
		for(int i=0;i<cantSubGrupos;i++) {
			List<String> subGrupo1=grupo1.subList((int)(tam1*i),(int)(tam1*(i+1)));
			List<String> subGrupo2=grupo2.subList((int)(tam2*i),(int)(tam2*(i+1)));
			
			SubGrupos temp=new SubGrupos(subGrupo1,subGrupo2,prueba,msj);
			if(temp.busqueda50porciento()>0) {
				subGruposCorrectos.add(temp);
			}
		}
	}
	
	public ArrayList<String> desordenarArray(ArrayList<String> array) {
		ArrayList arrDes = new ArrayList();
		Random randNum=new Random();
		while (array.size()>0){
			int i=(int) (Math.random()*array.size());
			arrDes.add(array.get(i));
			array.remove(i);
		}
		//System.out.println(arrDes.toString());
		return arrDes;
	}
}
