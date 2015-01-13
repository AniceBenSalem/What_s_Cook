package fr.iutinfo.exceptions;

/**
 * Quand on veut mettre une ile sur un placement où il y a deja une autre ile
 * @author dumetza
 *
 */
public class PlacementOccupeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PlacementOccupeException () {
		System.out.println("Impossible de placer une ile a cet endroit : deja occupe.");
	}
}
