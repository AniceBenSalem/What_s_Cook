package fr.iutinfo;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Armee {
	private Map<Unite,Integer> effectifs;
	
	public Armee(){
		this.effectifs=new TreeMap<Unite,Integer>();
	}
	
	public int getForce(){
		int f=0;
		for(Entry<Unite,Integer> e :effectifs.entrySet()){
			f+= e.getKey().getForce();
		}
		return f;
	}
}
