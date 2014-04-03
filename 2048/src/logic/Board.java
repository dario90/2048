package logic;

import java.util.ArrayList;
import java.util.Random;

public class Board {
	private int dim;
	private int target;
	private Tile board[][];
	
	public Board(int dim, int target) {
		this.dim = dim;
		this.target = target;
		
		board = new Tile[dim][dim];
		for (int i = 0; i < dim; i++)
			for (int j = 0; j < dim; j++)
				board[i][j] = new Tile();
	}
	
	public void insertTile() {
		ArrayList<Tile> emptyTiles = this.getEmptyTiles();
		Random random = new Random();
		
		if (emptyTiles.size() > 0) {
			int pos = random.nextInt(emptyTiles.size());
			
			if (random.nextInt(10) <= 6)
				emptyTiles.get(pos).activate(2);
			else 
				emptyTiles.get(pos).activate(4);
		}
	}
	
	public void move(Direction dir) {
		switch (dir) {
		case UP:
			Movers.up(board, dim);
			break;
		case DOWN:
			Movers.down(board, dim);
			break;
		case LEFT:
			Movers.left(board, dim);
			break;
		case RIGHT:
			Movers.right(board, dim);
			break;
		}
		if (this.checkWin()) {
			// TODO throws exception
		}
	}
	
	public Tile[][] getBoard() {
		Tile boardCopy[][] = new Tile[dim][dim];
		
		for (int i = 0; i < dim; i++)
			for (int j = 0; j < dim; j++)
				try {
					boardCopy[i][j] = (Tile) board[i][j].clone();
				} catch (CloneNotSupportedException e) {
					System.out.println("This should not happen");
				}
		return boardCopy;
	}
	
	private boolean checkWin() {
		for (int i = 0; i < dim; i++)
			for (int j = 0; j < dim; j++)
				if(board[i][j].getNumber() == target)
					return true;
		return false;
	}
	
	private ArrayList<Tile> getEmptyTiles() {
		ArrayList<Tile> emptyList = new ArrayList<Tile>();
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				if (board[i][j].isEmpty())
					emptyList.add(board[i][j]);
			}
		}
		return emptyList;
	}
}