package pieces;

import java.util.ArrayList;

import chess.Cell;

/**
 * La clase Rey extiende la clase Pieza y contiene métodos para mover el rey y
 * comprobar si está bajo amenaza en una
 * partida de ajedrez.
 * 
 * @author Fernando Pereira
 * @version 1.0
 * @see Piece
 * @since 1.0
 */
public class King extends Piece {

	private int x, y; // Variables adicionales para la clase King para mantener un registro de la
						// posición del rey

	/**
	 * Crea un nuevo objeto King con los parámetros proporcionados.
	 *
	 * @param i el identificador del objeto King
	 * @param p la ruta del objeto King
	 * @param c el color del objeto King
	 * @param x la coordenada x del objeto King
	 * @param y la coordenada y del objeto King
	 */
	public King(String i, String p, int c, int x, int y) {
		setx(x);
		sety(y);
		setId(i);
		setPath(p);
		setColor(c);
	}

	// funciones generales de acceso a valores
	/**
	 * Establece la coordenada x del objeto.
	 *
	 * @param x la nueva coordenada x del objeto
	 */
	public void setx(int x) {
		this.x = x;
	}

	/**
	 * Establece la coordenada y del objeto.
	 *
	 * @param y la nueva coordenada y del objeto
	 */
	public void sety(int y) {
		this.y = y;
	}

	/**
	 * Obtiene la coordenada x del objeto.
	 *
	 * @return la coordenada x del objeto
	 */
	public int getx() {
		return x;
	}

	/**
	 * Obtiene la coordenada y del objeto.
	 *
	 * @return la coordenada y del objeto
	 */
	public int gety() {
		return y;
	}

	/**
	 * Calcula y devuelve una lista de celdas posibles a las que el Rey puede
	 * moverse.
	 *
	 * @param state la matriz de estado del tablero de ajedrez
	 * @param x     la coordenada x actual del Rey
	 * @param y     la coordenada y actual del Rey
	 * @return una lista de celdas posibles a las que el Rey puede moverse
	 */
	public ArrayList<Cell> move(Cell state[][], int x, int y) {
		// El rey sólo puede moverse un paso. Así que todas las 8 celdas adyacentes han
		// sido
		// considerado.
		possiblemoves.clear();
		int posx[] = { x, x, x + 1, x + 1, x + 1, x - 1, x - 1, x - 1 };
		int posy[] = { y - 1, y + 1, y - 1, y, y + 1, y - 1, y, y + 1 };
		for (int i = 0; i < 8; i++)
			if ((posx[i] >= 0 && posx[i] < 8 && posy[i] >= 0 && posy[i] < 8))
				if ((state[posx[i]][posy[i]].getpiece() == null
						|| state[posx[i]][posy[i]].getpiece().getcolor() != this.getcolor()))
					possiblemoves.add(state[posx[i]][posy[i]]);
		return possiblemoves;
	}

	/**
	 * La función comprueba si una pieza de ajedrez dada está en peligro de ser
	 * atacada por cualquier pieza contraria en
	 * el tablero.
	 * 
	 * @param state un array 2D que representa el estado actual del tablero de
	 *              ajedrez, donde cada elemento es un
	 *              objeto Celda que contiene información sobre la pieza en esa
	 *              celda (si la hay) y su posición en el
	 *              tablero.
	 * @return El método devuelve un valor booleano, que es verdadero si la pieza
	 *         actual está en peligro de
	 *         ser capturada por una pieza del adversario, y falso en caso
	 *         contrario.
	 */
	public boolean isindanger(Cell state[][]) {

		// Comprobación de ataque desde la izquierda, derecha, arriba y abajo.
		for (int i = x + 1; i < 8; i++) {
			if (state[i][y].getpiece() == null)
				continue;
			else if (state[i][y].getpiece().getcolor() == this.getcolor())
				break;
			else {
				if ((state[i][y].getpiece() instanceof Rook) || (state[i][y].getpiece() instanceof Queen))
					return true;
				else
					break;
			}
		}
		for (int i = x - 1; i >= 0; i--) {
			if (state[i][y].getpiece() == null)
				continue;
			else if (state[i][y].getpiece().getcolor() == this.getcolor())
				break;
			else {
				if ((state[i][y].getpiece() instanceof Rook) || (state[i][y].getpiece() instanceof Queen))
					return true;
				else
					break;
			}
		}
		for (int i = y + 1; i < 8; i++) {
			if (state[x][i].getpiece() == null)
				continue;
			else if (state[x][i].getpiece().getcolor() == this.getcolor())
				break;
			else {
				if ((state[x][i].getpiece() instanceof Rook) || (state[x][i].getpiece() instanceof Queen))
					return true;
				else
					break;
			}
		}
		for (int i = y - 1; i >= 0; i--) {
			if (state[x][i].getpiece() == null)
				continue;
			else if (state[x][i].getpiece().getcolor() == this.getcolor())
				break;
			else {
				if ((state[x][i].getpiece() instanceof Rook) || (state[x][i].getpiece() instanceof Queen))
					return true;
				else
					break;
			}
		}

		// comprobación de ataque desde dirección diagonal
		int tempx = x + 1, tempy = y - 1;
		while (tempx < 8 && tempy >= 0) {
			if (state[tempx][tempy].getpiece() == null) {
				tempx++;
				tempy--;
			} else if (state[tempx][tempy].getpiece().getcolor() == this.getcolor())
				break;
			else {
				if (state[tempx][tempy].getpiece() instanceof Bishop || state[tempx][tempy].getpiece() instanceof Queen)
					return true;
				else
					break;
			}
		}
		tempx = x - 1;
		tempy = y + 1;
		while (tempx >= 0 && tempy < 8) {
			if (state[tempx][tempy].getpiece() == null) {
				tempx--;
				tempy++;
			} else if (state[tempx][tempy].getpiece().getcolor() == this.getcolor())
				break;
			else {
				if (state[tempx][tempy].getpiece() instanceof Bishop || state[tempx][tempy].getpiece() instanceof Queen)
					return true;
				else
					break;
			}
		}
		tempx = x - 1;
		tempy = y - 1;
		while (tempx >= 0 && tempy >= 0) {
			if (state[tempx][tempy].getpiece() == null) {
				tempx--;
				tempy--;
			} else if (state[tempx][tempy].getpiece().getcolor() == this.getcolor())
				break;
			else {
				if (state[tempx][tempy].getpiece() instanceof Bishop || state[tempx][tempy].getpiece() instanceof Queen)
					return true;
				else
					break;
			}
		}
		tempx = x + 1;
		tempy = y + 1;
		while (tempx < 8 && tempy < 8) {
			if (state[tempx][tempy].getpiece() == null) {
				tempx++;
				tempy++;
			} else if (state[tempx][tempy].getpiece().getcolor() == this.getcolor())
				break;
			else {
				if (state[tempx][tempy].getpiece() instanceof Bishop || state[tempx][tempy].getpiece() instanceof Queen)
					return true;
				else
					break;
			}
		}

		// Comprobación de ataque del Caballero del color opuesto
		int posx[] = { x + 1, x + 1, x + 2, x + 2, x - 1, x - 1, x - 2, x - 2 };
		int posy[] = { y - 2, y + 2, y - 1, y + 1, y - 2, y + 2, y - 1, y + 1 };
		for (int i = 0; i < 8; i++)
			if ((posx[i] >= 0 && posx[i] < 8 && posy[i] >= 0 && posy[i] < 8))
				if (state[posx[i]][posy[i]].getpiece() != null
						&& state[posx[i]][posy[i]].getpiece().getcolor() != this.getcolor()
						&& (state[posx[i]][posy[i]].getpiece() instanceof Knight)) {
					return true;
				}

		// Comprobación de ataque del Peón de color opuesto
		int pox[] = { x + 1, x + 1, x + 1, x, x, x - 1, x - 1, x - 1 };
		int poy[] = { y - 1, y + 1, y, y + 1, y - 1, y + 1, y - 1, y };
		{
			for (int i = 0; i < 8; i++)
				if ((pox[i] >= 0 && pox[i] < 8 && poy[i] >= 0 && poy[i] < 8))
					if (state[pox[i]][poy[i]].getpiece() != null
							&& state[pox[i]][poy[i]].getpiece().getcolor() != this.getcolor()
							&& (state[pox[i]][poy[i]].getpiece() instanceof King)) {
						return true;
					}
		}
		if (getcolor() == 0) {
			if (x > 0 && y > 0 && state[x - 1][y - 1].getpiece() != null
					&& state[x - 1][y - 1].getpiece().getcolor() == 1
					&& (state[x - 1][y - 1].getpiece() instanceof Pawn))
				return true;
			if (x > 0 && y < 7 && state[x - 1][y + 1].getpiece() != null
					&& state[x - 1][y + 1].getpiece().getcolor() == 1
					&& (state[x - 1][y + 1].getpiece() instanceof Pawn))
				return true;
		} else {
			if (x < 7 && y > 0 && state[x + 1][y - 1].getpiece() != null
					&& state[x + 1][y - 1].getpiece().getcolor() == 0
					&& (state[x + 1][y - 1].getpiece() instanceof Pawn))
				return true;
			if (x < 7 && y < 7 && state[x + 1][y + 1].getpiece() != null
					&& state[x + 1][y + 1].getpiece().getcolor() == 0
					&& (state[x + 1][y + 1].getpiece() instanceof Pawn))
				return true;
		}
		return false;
	}
}