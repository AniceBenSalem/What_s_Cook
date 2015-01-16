package fr.iutinfo;

import java.util.HashMap;

public class Data {
	public static HashMap<Integer,Ile> dataIles = new HashMap<Integer,Ile>();
	
	public static Ile getFromID(int id){
		return dataIles.get(id);
	}
}
