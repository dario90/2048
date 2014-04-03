package logic;

import java.util.ArrayList;

public class Movers {
	public static void up(Tile board[][],int dim) {
		for (int j = 0; j < dim; j++) {
			for (int i = 0; i < dim; i++) {
				ArrayList<Integer> merged = new ArrayList<Integer>();
				if (!board[i][j].isEmpty()) {
					int k = i,n = i-1;
					while (n >= 0) {
						if (board[n][j].isEmpty()) {
							board[k][j].slide(board[n][j]);
							k = n; 
							n--;
						}
						else {
							if (board[n][j].couldSum(board[k][j]) && !merged.contains(new Integer(n))) {
								board[n][j].merge(board[k][j]);
								merged.add(new Integer(n));
							}
							break;
						}
					}
				}
			}
		}
	}
	
	public static void down(Tile board[][],int dim) {
		for (int j = 0; j < dim; j++) {
			for (int i = dim-1; i >= 0; i--) {
				ArrayList<Integer> merged = new ArrayList<Integer>();
				if (!board[i][j].isEmpty()) {
					int k = i,n = i+1;
					while (n < dim) {
						if (board[n][j].isEmpty()) {
							board[k][j].slide(board[n][j]);
							k = n; 
							n++;
						}
						else {
							if (board[k][j].couldSum(board[n][j]) && !merged.contains(new Integer(n))) {
								board[n][j].merge(board[k][j]);
								merged.add(new Integer(n));
							}
							break;
						}
					}
				}
			}
		}
	}

	public static void left(Tile board[][],int dim) {
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				ArrayList<Integer> merged = new ArrayList<Integer>();
				if (!board[i][j].isEmpty()) {
					int k = j,n = j-1;
					while (n >= 0) {
						if (board[i][n].isEmpty()) {
							board[i][k].slide(board[i][n]);
							k = n; 
							n--;
						}
						else {
							if (board[i][k].couldSum(board[i][n]) && !merged.contains(new Integer(n))) {
								board[i][n].merge(board[i][k]);
								merged.add(new Integer(n));
							}
							break;
						}
					}
				}
			}
		}
	}

	public static void right(Tile board[][],int dim) {
		for (int i = 0; i < dim; i++) {
			for (int j = dim-1; j >= 0; j--) {
				ArrayList<Integer> merged = new ArrayList<Integer>();
				if (!board[i][j].isEmpty()) {
					int k = j,n = j+1;
					while (n < dim) {
						if (board[i][n].isEmpty()) {
							board[i][k].slide(board[i][n]);
							k = n; 
							n++;
						}
						else {
							if (board[i][k].couldSum(board[i][n]) && !merged.contains(new Integer(n))) {
								board[i][n].merge(board[i][k]);
								merged.add(new Integer(n));
							}
							break;
						}
					}
				}
			}
		}
	}
}
