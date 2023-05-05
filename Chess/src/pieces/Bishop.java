package pieces;

import java.util.ArrayList;

import chess.Cell;

/**
 * Esta es la Clase Alfil.
 * La Función Mover define las reglas básicas para el movimiento del Alfil en un
 * tablero de ajedrez.
 * tablero de ajedrez
 * 
 * @author Fernando Pereira
 * @version 1.0
 * @see Piece
 * @since 1.0
 *
 */
public class Bishop extends Piece {

	// Constructor
	/**
	 * Crea un objeto de tipo Bishop con la identificación, ruta de imagen y color
	 * especificados.
	 *
	 * @param i la identificación del Bishop
	 * @param p la ruta de la imagen del Bishop
	 * @param c el color del Bishop (0 para blanco, 1 para negro)
	 */
	public Bishop(String i, String p, int c) {
		setId(i);
		setPath(p);
		setColor(c);
	}

	/**
	 * La función define los posibles movimientos de una pieza alfil en un tablero
	 * de ajedrez.
	 * 
	 * @param state Un array 2D que representa el estado actual del tablero de
	 *              ajedrez, donde cada elemento es un
	 *              objeto Celda.
	 * @param x     La coordenada x de la posición actual del alfil en el tablero de
	 *              ajedrez.
	 * @param y     El parámetro "y" representa la posición vertical del alfil en el
	 *              tablero. Es
	 *              es un valor entero que va de 0 a 7, donde 0 representa la fila
	 *              inferior y 7 la superior del tablero.
	 *              fila superior del tablero.
	 * @return El método devuelve un ArrayList de objetos Cell, que representan los
	 *         posibles movimientos
	 *         que una pieza de ajedrez Alfil puede hacer en un determinado estado
	 *         del tablero de ajedrez.
	 */
	public ArrayList<Cell> move(Cell state[][], int x, int y) {
		// El alfil puede moverse en diagonal en las 4 direcciones (NW,NE,SW,SE)
		// Esta función define esa lógica
		possiblemoves.clear();
		int tempx = x + 1, tempy = y - 1;
		while (tempx < 8 && tempy >= 0) {
			if (state[tempx][tempy].getpiece() == null) {
				possiblemoves.add(state[tempx][tempy]);
			} else if (state[tempx][tempy].getpiece().getcolor() == this.getcolor())
				break;
			else {
				possiblemoves.add(state[tempx][tempy]);
				break;
			}
			tempx++;
			tempy--;
		}
		tempx = x - 1;
		tempy = y + 1;
		while (tempx >= 0 && tempy < 8) {
			if (state[tempx][tempy].getpiece() == null)
				possiblemoves.add(state[tempx][tempy]);
			else if (state[tempx][tempy].getpiece().getcolor() == this.getcolor())
				break;
			else {
				possiblemoves.add(state[tempx][tempy]);
				break;
			}
			tempx--;
			tempy++;
		}
		tempx = x - 1;
		tempy = y - 1;
		while (tempx >= 0 && tempy >= 0) {
			if (state[tempx][tempy].getpiece() == null)
				possiblemoves.add(state[tempx][tempy]);
			else if (state[tempx][tempy].getpiece().getcolor() == this.getcolor())
				break;
			else {
				possiblemoves.add(state[tempx][tempy]);
				break;
			}
			tempx--;
			tempy--;
		}
		tempx = x + 1;
		tempy = y + 1;
		while (tempx < 8 && tempy < 8) {
			if (state[tempx][tempy].getpiece() == null)
				possiblemoves.add(state[tempx][tempy]);
			else if (state[tempx][tempy].getpiece().getcolor() == this.getcolor())
				break;
			else {
				possiblemoves.add(state[tempx][tempy]);
				break;
			}
			tempx++;
			tempy++;
		}
		return possiblemoves;
	}
}