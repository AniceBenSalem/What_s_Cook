package fr.iutinfo;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Armee {
	private static Map<Unite,Integer> effectifs;
	
	public Armee(){
		Armee.effectifs=new TreeMap<Unite,Integer>();
	}
	
	public static int getForce(){
		int f=0;
		for(Entry<Unite,Integer> e :effectifs.entrySet())
			f+= e.getKey().getForce();
		return f;
	}
}
