package pieces;

import java.util.ArrayList;

import chess.Cell;

/**
 * Esta es la clase Knight heredada de la clase abstracta Piece.
 * 
 * @author Fernando Pereira
 * @version 1.0
 * @see Piece
 * @since 1.0
 */
public class Knight extends Piece {

	// Constructor
	/**
	 * Crea un objeto de tipo Knight con la identificación, ruta de imagen y color
	 * especificados.
	 *
	 * @param i la identificación del Knight
	 * @param p la ruta de la imagen del Knight
	 * @param c el color del Knight (0 para blanco, 1 para negro)
	 */
	public Knight(String i, String p, int c) {
		setId(i);
		setPath(p);
		setColor(c);
	}

	/**
	 * La función calcula y devuelve una lista de posibles jugadas para una casilla
	 * dada de un tablero de ajedrez.
	 * 
	 * @param state una matriz 2D de objetos Cell que representan el estado actual
	 *              del tablero de juego
	 * @param x     La coordenada x de la posición actual de la pieza en el tablero
	 *              de ajedrez.
	 * @param y     El parámetro y representa la posición vertical de una casilla en
	 *              un tablero de ajedrez. Se utiliza en
	 *              el método move() para calcular los posibles movimientos de una
	 *              pieza de ajedrez situada en una celda específica (x,y)
	 *              del tablero.
	 * @return El método devuelve un ArrayList de objetos Cell, que representan los
	 *         posibles movimientos
	 *         que una pieza de ajedrez puede hacer desde su posición actual en el
	 *         tablero.
	 */
	public ArrayList<Cell> move(Cell state[][], int x, int y) {
		possiblemoves.clear();
		int posx[] = { x + 1, x + 1, x + 2, x + 2, x - 1, x - 1, x - 2, x - 2 };
		int posy[] = { y - 2, y + 2, y - 1, y + 1, y - 2, y + 2, y - 1, y + 1 };
		for (int i = 0; i < 8; i++)
			if ((posx[i] >= 0 && posx[i] < 8 && posy[i] >= 0 && posy[i] < 8))
				if ((state[posx[i]][posy[i]].getpiece() == null
						|| state[posx[i]][posy[i]].getpiece().getcolor() != this.getcolor())) {
					possiblemoves.add(state[posx[i]][posy[i]]);
				}
		return possiblemoves;
	}
}