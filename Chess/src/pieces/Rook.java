package pieces;

import java.util.ArrayList;

import chess.Cell;

/**
 * Esta es la clase Torre heredada de la clase abstracta Pieza
 *
 * @author Fernando Pereira
 * @version 1.0
 * @see Piece
 * @since 1.0
 */
public class Rook extends Piece {

	// Constructor
	/**
	 * Crea un objeto de tipo Rook con la identificación, ruta de imagen y color
	 * especificados.
	 *
	 * @param i la identificación de la Rook
	 * @param p la ruta de la imagen de la Rook
	 * @param c el color de la Rook (0 para blanco, 1 para negro)
	 */
	public Rook(String i, String p, int c) {
		setId(i);
		setPath(p);
		setColor(c);
	}

	// Move function defined
	/**
	 * Esta función calcula todos los movimientos posibles de una torre en un
	 * tablero de ajedrez dada su posición actual.
	 * 
	 * @param state una matriz 2D que representa el estado actual del tablero de
	 *              ajedrez, donde cada elemento es un
	 *              Objeto celda
	 * @param x     La coordenada x de la posición actual de la torre en el tablero
	 *              de ajedrez.
	 * @param y     El parámetro y representa la posición vertical de la Torre en el
	 *              tablero. Se utiliza
	 *              para recorrer las casillas verticalmente y buscar posibles
	 *              movimientos.
	 * @return El método devuelve un ArrayList de tipo Cell, que contiene todas las
	 *         posibles jugadas
	 *         que una Torre puede hacer desde su posición actual en el tablero.
	 */
	public ArrayList<Cell> move(Cell state[][], int x, int y) {
		// La torre sólo puede moverse horizontal o verticalmente
		possiblemoves.clear();
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
		return possiblemoves;
	}
}
