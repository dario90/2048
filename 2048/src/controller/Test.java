package controller;

import logic.*;
import view.*;

public class Test {
	public static void main(String args[]) {
		Board b = new Board(4,2048);
		TextualView v = new TextualView();
		
		v.draw(b.getBoard(), 4);
	}
}
