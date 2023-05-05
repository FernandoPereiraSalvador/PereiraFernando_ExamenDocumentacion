package pieces;

import java.util.ArrayList;

import chess.Cell;

/**
 * Esta es la clase Peón heredada de la pieza
 *
 * @author Fernando Pereira
 * @version 1.0
 * @see Piece
 * @since 1.0
 */
public class Pawn extends Piece {

	// COnstructors
	/**
	 * Crea un objeto de tipo Pawn con la identificación, ruta de imagen y color
	 * especificados.
	 *
	 * @param i la identificación del Pawn
	 * @param p la ruta de la imagen del Pawn
	 * @param c el color del Pawn (0 para blanco, 1 para negro)
	 */
	public Pawn(String i, String p, int c) {
		setId(i);
		setPath(p);
		setColor(c);
	}

	/**
	 * La función determina los posibles movimientos de un peón en un tablero de
	 * ajedrez.
	 * 
	 * @param state una matriz 2D que representa el estado actual del tablero de
	 *              ajedrez, donde cada elemento es un
	 *              Objeto celda
	 * @param x     El número de fila de la posición actual del peón en el tablero
	 *              de ajedrez.
	 * @param y     El índice de columna de la celda en la matriz 2D que representa
	 *              el tablero de ajedrez.
	 * @return El método devuelve un ArrayList de posibles movimientos para una
	 *         pieza de peón en un tablero de ajedrez.
	 */
	public ArrayList<Cell> move(Cell state[][], int x, int y) {
		// El peón sólo puede mover un paso, excepto en la primera oportunidad, en la
		// que puede mover 2 pasos
		// Sólo puede moverse en diagonal para atacar a una pieza opuesta.
		// color
		// No puede retroceder ni avanzar para alcanzar una pieza.

		possiblemoves.clear();
		if (getcolor() == 0) {
			if (x == 0)
				return possiblemoves;
			if (state[x - 1][y].getpiece() == null) {
				possiblemoves.add(state[x - 1][y]);
				if (x == 6) {
					if (state[4][y].getpiece() == null)
						possiblemoves.add(state[4][y]);
				}
			}
			if ((y > 0) && (state[x - 1][y - 1].getpiece() != null)
					&& (state[x - 1][y - 1].getpiece().getcolor() != this.getcolor()))
				possiblemoves.add(state[x - 1][y - 1]);
			if ((y < 7) && (state[x - 1][y + 1].getpiece() != null)
					&& (state[x - 1][y + 1].getpiece().getcolor() != this.getcolor()))
				possiblemoves.add(state[x - 1][y + 1]);
		} else {
			if (x == 8)
				return possiblemoves;
			if (state[x + 1][y].getpiece() == null) {
				possiblemoves.add(state[x + 1][y]);
				if (x == 1) {
					if (state[3][y].getpiece() == null)
						possiblemoves.add(state[3][y]);
				}
			}
			if ((y > 0) && (state[x + 1][y - 1].getpiece() != null)
					&& (state[x + 1][y - 1].getpiece().getcolor() != this.getcolor()))
				possiblemoves.add(state[x + 1][y - 1]);
			if ((y < 7) && (state[x + 1][y + 1].getpiece() != null)
					&& (state[x + 1][y + 1].getpiece().getcolor() != this.getcolor()))
				possiblemoves.add(state[x + 1][y + 1]);
		}
		return possiblemoves;
	}
}
