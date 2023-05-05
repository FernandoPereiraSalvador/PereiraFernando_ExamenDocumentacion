package pieces;

import java.util.ArrayList;

import chess.Cell;

/**
 * Esta es la clase Queen heredada de la clase abstracta Piece
 *
 * @author Fernando Pereira
 * @version 1.0
 * @see Piece
 * @since 1.0
 */
public class Queen extends Piece {

	// Constructors
	/**
	 * Crea un objeto de tipo Queen con la identificación, ruta de imagen y color
	 * especificados.
	 *
	 * @param i la identificación de la Queen
	 * @param p la ruta de la imagen de la Queen
	 * @param c el color de la Queen (0 para blanco, 1 para negro)
	 */
	public Queen(String i, String p, int c) {
		setId(i);
		setPath(p);
		setColor(c);
	}

	/**
	 * Esta función calcula todos los movimientos posibles de una reina en un
	 * tablero de ajedrez.
	 * 
	 * @param state un array 2D que representa el estado actual del tablero de
	 *              ajedrez, donde cada elemento es un
	 *              objeto Celda que contiene información sobre la pieza en esa
	 *              celda (si la hay) y su posición en el
	 *              tablero.
	 * @param x     La coordenada x de la posición actual de la Reina en el tablero
	 *              de ajedrez.
	 * @param y     El parámetro y representa el número de columna de la celda en el
	 *              tablero de ajedrez. Se utiliza para
	 *              determinar los posibles movimientos de una pieza reina en las
	 *              direcciones vertical y horizontal.
	 * @return El método devuelve un ArrayList de objetos Cell, que representan los
	 *         posibles movimientos
	 *         que una pieza Reina puede hacer en un tablero de ajedrez.
	 */
	public ArrayList<Cell> move(Cell state[][], int x, int y) {
		// La reina tiene el mayor número de movimientos posibles
		// La reina puede moverse cualquier número de pasos en las 8 direcciones
		// Los posibles movimientos de la reina es una combinación de Torre y Alfil
		possiblemoves.clear();

		// Comprobación de posibles movimientos en dirección vertical
		int tempx = x - 1;
		while (tempx >= 0) {
			if (state[tempx][y].getpiece() == null)
				possiblemoves.add(state[tempx][y]);
			else if (state[tempx][y].getpiece().getcolor() == this.getcolor())
				break;
			else {
				possiblemoves.add(state[tempx][y]);
				break;
			}
			tempx--;
		}

		tempx = x + 1;
		while (tempx < 8) {
			if (state[tempx][y].getpiece() == null)
				possiblemoves.add(state[tempx][y]);
			else if (state[tempx][y].getpiece().getcolor() == this.getcolor())
				break;
			else {
				possiblemoves.add(state[tempx][y]);
				break;
			}
			tempx++;
		}

		// Checking possible moves in horizontal Direction
		int tempy = y - 1;
		while (tempy >= 0) {
			if (state[x][tempy].getpiece() == null)
				possiblemoves.add(state[x][tempy]);
			else if (state[x][tempy].getpiece().getcolor() == this.getcolor())
				break;
			else {
				possiblemoves.add(state[x][tempy]);
				break;
			}
			tempy--;
		}
		tempy = y + 1;
		while (tempy < 8) {
			if (state[x][tempy].getpiece() == null)
				possiblemoves.add(state[x][tempy]);
			else if (state[x][tempy].getpiece().getcolor() == this.getcolor())
				break;
			else {
				possiblemoves.add(state[x][tempy]);
				break;
			}
			tempy++;
		}

		// Comprobación de posibles movimientos en dirección diagonal
		tempx = x + 1;
		tempy = y - 1;
		while (tempx < 8 && tempy >= 0) {
			if (state[tempx][tempy].getpiece() == null)
				possiblemoves.add(state[tempx][tempy]);
			else if (state[tempx][tempy].getpiece().getcolor() == this.getcolor())
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