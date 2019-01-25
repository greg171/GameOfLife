package org.launchcode;

public class Main {

    public static void main(String[] args) {
	game g = new game(10);
        while (true) {
            g.checkNeighbors();
            g.showGrid();
        }
    }
}
