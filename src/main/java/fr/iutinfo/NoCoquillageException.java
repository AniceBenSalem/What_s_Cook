package fr.iutinfo;

public class NoCoquillageException extends Exception {

	public NoCoquillageException () {
		System.out.println("Le nombre de coquillages que vous possédez est insuffisant.");
	}
}

