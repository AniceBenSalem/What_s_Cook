package fr.iutinfo.exceptions;

public class NoCoquillageException extends Exception {

	/**
	 * Quand on n'a pas assez de coquillage pour des envois ou autre
	 */
	private static final long serialVersionUID = 1L;

	public NoCoquillageException () {
		System.out.println("Le nombre de coquillages que vous possédez est insuffisant.");
	}
}

