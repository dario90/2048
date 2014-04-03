package view;

import logic.*;

public class TextualView implements View {

	public void draw(Tile[][] board,int dim) {
		for (int i = 0; i < dim; i++) {
			printRow(board,i,dim);
		}
	}
	
	private void printRow(Tile[][] board,int row,int dim) {
		printBorder(dim);
		printVoid(dim);
		printContent(board,row,dim);
		printVoid(dim);
		if (row == dim-1)
			printBorder(dim);
	}
	
	private void printBorder(int dim) {
		for (int i = 0; i < dim-1; i++)
			System.out.print("+------");
		System.out.println("+------+");
	}
	
	private void printVoid(int dim) {
		for (int i = 0; i < dim-1; i++) 
			System.out.print("+      ");
		System.out.println("+      +");
	}
	
	private void printContent(Tile[][] board,int row,int dim) {
		for (int i = 0; i < dim-1; i++) {
			if (!board[row][i].isEmpty()) {
				if (board[row][i].getNumber() < 10)
					System.out.print("+   "+board[row][i].getNumber()+"  ");
				else if (board[row][i].getNumber() < 100)
					System.out.print("+  "+board[row][i].getNumber()+"   ");
				else if (board[row][i].getNumber() < 1000)
					System.out.print("+ "+board[row][i].getNumber()+"  ");
				else if (board[row][i].getNumber() < 10000)
					System.out.print("+ "+board[row][i].getNumber()+" ");
			}
			else {
				System.out.print("+      ");
			}
		}
		if (!board[row][dim-1].isEmpty()) {
			if (board[row][dim-1].getNumber() < 10)
				System.out.println("+   "+board[row][dim-1].getNumber()+"  +");
			else if (board[row][dim-1].getNumber() < 100)
				System.out.println("+  "+board[row][dim-1].getNumber()+"   +");
			else if (board[row][dim-1].getNumber() < 1000)
				System.out.println("+ "+board[row][dim-1].getNumber()+"  +");
			else if (board[row][dim-1].getNumber() < 10000)
				System.out.println("+ "+board[row][dim-1].getNumber()+" +");
		}
		else {
			System.out.print("+      ");
		}
	} 
}