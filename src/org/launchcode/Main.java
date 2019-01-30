package org.launchcode;

public class Main {

    public static void main(String[] args) {
	game g = new game(80);
	int count = 0;
        while (true) {
            g.checkNeighbors();
            g.showGrid();
            count++;
            if(count == 8){
                System.exit(0);
            }
        }
    }
}
