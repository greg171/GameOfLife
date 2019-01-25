package org.launchcode;

public class game {


    String[][] grid;
    int[][] neighbors;
    int[][] directions = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};

    game(int gridSize) {
        this.neighbors = new int[gridSize][gridSize];
        this.grid = new String[gridSize][gridSize];
        for (int row = 0; row < this.grid.length; row++) {
            for (int cell = 0; cell < this.grid[row].length; cell++) {
                this.grid[row][cell] = (Math.random() > .9) ? "x|" : " |";
                System.out.print(this.grid[row][cell]);
            }
            System.out.println();
        }
    }
}
