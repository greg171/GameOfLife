package org.launchcode;

public class game {


    private String[][] grid;
    private int[][] neighborsCounts;
    private static final int[][] directions = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};

    game(int gridSize) {
        int count = 0;
        grid = new String[gridSize][gridSize];
        neighborsCounts = new int[grid.length][grid[0].length];
        this.grid = new String[gridSize][gridSize];

        for (int row = 0; row < this.grid.length; row++) {
            for (int cell = 0; cell < this.grid[row].length; cell++) {
                this.grid[row][cell] = (Math.random() > .5) ? "x|" : " |";
                System.out.print(this.grid[row][cell]);
            }
            System.out.println();
        }
    }

    void checkNeighbors() {
        int count = 0;
        for (int row = 0; row < this.grid.length; row++) {
            for (int col = 0; col < this.grid[row].length; col++) {
                for (int[] direction : directions) {
                    int y = row + direction[0];
                    int x = col + direction[1];
                    if (x < 0) {
                        x += this.grid.length;
                    } else if (x >= grid.length) {
                        x -= grid.length;
                    }
                    if (y < 0) {
                        y += this.grid[row].length;
                    } else if (y + 1 > this.grid[row].length) {
                        y -= y;
                    }
                    if (this.grid[x][y] == "x|") count++;
                }
                neighborsCounts[row][col] = count;
                count = 0;
            }
        }
    }

    void showGrid() {

        for (int row = 0; row < this.grid.length; row++) {
            for (int cell = 0; cell < this.grid[row].length; cell++) {
                //Creation of life scenario
                if (this.grid[row][cell] == " |" && this.neighborsCounts[row][cell] == 3 ) {
                    this.grid[row][cell] = "x|";
                    //Overcrowding scenario
                } else if (this.grid[row][cell] == "x|" && this.neighborsCounts[row][cell] > 3) {
                    this.grid[row][cell] = " |";
                    // Underpopulation scenario
                } else if (this.grid[row][cell] == "x|" && this.neighborsCounts[row][cell] < 2) {
                    this.grid[row][cell] = " |";
                    //No interactions scenario
                }else if(this.grid[row][cell] == " |" && this.neighborsCounts[row][cell] == 0){
                    break;
                    //Survival scenario
                }else if(this.grid[row][cell] == "x|" && this.neighborsCounts[row][cell] == 2 || this.grid[row][cell] == "x|" && this.neighborsCounts[row][cell] == 3){
                    break;
                }
                System.out.print(this.grid[row][cell]);
            }
            System.out.println();
        }
        this.checkNeighbors();
    }
}

