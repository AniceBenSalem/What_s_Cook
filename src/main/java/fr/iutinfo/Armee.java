package fr.iutinfo;

import java.util.Map;
import java.util.TreeMap;

public class Armee {
	private Map<Unite,Integer> effectifs;
	
	public Armee(){
		this.effectifs=new TreeMap<Unite,Integer>();
	}
}
