package controller;

import java.util.Scanner;

import logic.*;
import view.*;

public class Test {
	public static void main(String args[]) {
		Board b = new Board(4,2048);
		TextualView v = new TextualView();
		Scanner keyboard = new Scanner(System.in);
		
		b.insertTile();
		b.insertTile();
		while (true) {
			v.draw(b.getBoard(),4);
			System.out.print("Move: ");
			switch(keyboard.nextLine().toLowerCase()) {
			case "up":
				b.move(Direction.UP);
				break;
			case "down":
				b.move(Direction.DOWN);
				break;
			case "left":
				b.move(Direction.LEFT);
				break;
			case "right":
				b.move(Direction.RIGHT);
				break;
			default:
				System.out.println("Undefined move");
				break;
			}
			b.insertTile();
		}
	}
}
