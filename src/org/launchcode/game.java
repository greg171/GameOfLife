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
        this.checkNeighbors();
    }

    void checkNeighbors() {
        int i = 0;
        for (int row = 0; row < this.grid.length; row++) {
            for (int col = 0; col < this.grid[row].length; col++) {
                for (int drow = 0; drow < this.directions.length; drow++) {
                    int x = (this.directions[drow][this.directions[drow].length - this.directions[drow].length]);
                    int y = (this.directions[drow][this.directions[drow].length - 1]);
                    x = row + x;
                    y = col + y;
                    if (x < 0) {
                        x += this.grid.length;
                    } else if (x + 1 > this.grid.length) {
                        x -= x;
                    }
                    if (y < 0) {
                        y += this.grid[row].length;
                    } else if (y + 1 > this.grid[row].length) {
                        y -= y;
                    }
                    if (this.grid[x][y] == "x|") i++;
                }
                this.neighbors[row][col] = i;
                i = 0;
            }
        }
        this.showGrid();
    }
    void showGrid() {
        for (int row = 0; row < this.grid.length; row++) {
            for (int cell = 0; cell < this.grid[row].length; cell++) {
                if (this.grid[row][cell] == " |" && this.neighbors[row][cell] == 3) {
                    this.grid[row][cell] = "x|";
                } else if (this.grid[row][cell] == "x|" && this.neighbors[row][cell] > 3) {
                    this.grid[row][cell] = " |";
                } else if (this.grid[row][cell] == "x|" && this.neighbors[row][cell] < 2) {
                    this.grid[row][cell] = " |";
                }
                System.out.print(this.grid[row][cell]);
            }
            System.out.println();
        }
        this.checkNeighbors();
    }
}
