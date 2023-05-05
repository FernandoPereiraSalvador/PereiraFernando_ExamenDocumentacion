package pieces;

import java.util.ArrayList;

import chess.Cell;

/**
 * Esta es la Clase Pieza. Es una clase abstracta de la que se heredan todas las
 * piezas reales.
 * Define todas las funciones comunes a todas las piezas
 * La función move() es una función abstracta que debe ser reemplazada en todas
 * las clases heredadas.
 * Implementa la interfaz Cloneable ya que se requiere una copia de la pieza muy
 * a menudo.
 * 
 * @author Fernando Pereira
 * @version 1.0
 * @implements Cloneable
 * @since 1.0
 */
public abstract class Piece implements Cloneable {

	// Variables miembros
	private int color;
	private String id = null;
	private String path;
	protected ArrayList<Cell> possiblemoves = new ArrayList<Cell>(); // Protected (access from child classes)

	public abstract ArrayList<Cell> move(Cell pos[][], int x, int y); // Abstract Function. Must be overridden

	// Id Setter
	/**
	 * Establece la identificación del objeto.
	 *
	 * @param id la identificación a establecer
	 */
	public void setId(String id) {
		this.id = id;
	}

	// Path Setter
	/**
	 * Establece la ruta de la imagen del objeto.
	 *
	 * @param path la ruta de la imagen a establecer
	 */
	public void setPath(String path) {
		this.path = path;
	}

	// Color Setter
	/**
	 * Establece el color del objeto.
	 *
	 * @param c el color a establecer (0 para blanco, 1 para negro)
	 */
	public void setColor(int c) {
		this.color = c;
	}

	// Path getter
	/**
	 * Obtiene la ruta de la imagen del objeto.
	 *
	 * @return la ruta de la imagen
	 */
	public String getPath() {
		return path;
	}

	// Id getter
	/**
	 * Obtiene la identificación del objeto.
	 *
	 * @return la identificación
	 */
	public String getId() {
		return id;
	}

	// Color Getter
	/**
	 * Obtiene el color del objeto.
	 *
	 * @return el color (0 para blanco, 1 para negro)
	 */
	public int getcolor() {
		return this.color;
	}

	/**
	 * Crea y devuelve una copia del objeto Piece.
	 *
	 * @return una copia del objeto Piece
	 * @throws CloneNotSupportedException si la clonación no es compatible con el
	 *                                    objeto
	 */
	public Piece getcopy() throws CloneNotSupportedException {
		return (Piece) this.clone();
	}
}