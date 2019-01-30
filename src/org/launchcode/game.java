package org.launchcode;

public class game {


    private String[][] gameGrid;
    private int[][] neighborsCount;
    //Set as static as directions are constant and will not change.
    private static final int[][] directions = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};

    game(int gridSize) {
        int count = 0;
        //Initialise size of the grid
        gameGrid = new String[gridSize][gridSize];
        neighborsCount = new int[gameGrid.length][gameGrid[0].length];
        this.gameGrid = new String[gridSize][gridSize];
        //Fill grid with random cells for game of life
        for (int row = 0; row < this.gameGrid.length; row++) {
            for (int cell = 0; cell < this.gameGrid[row].length; cell++) {
                this.gameGrid[row][cell] = (Math.random() > .9) ? "x|" : " |";
                System.out.print(this.gameGrid[row][cell]);

            }
            System.out.println();
        }
        System.out.println();
    }

    void checkNeighbors() {
        int count = 0;
        for (int row = 0; row < this.gameGrid.length; row++)
            for (int col = 0; col < this.gameGrid[row].length; col++) {
                //For each row and column take the direction we want to check
                for (int[] direction : directions) {
                    int y = row + direction[0];
                    int x = col + direction[1];
                    //if x less than 0, assign the value of the grid's length
                    if (x < 0) {
                        x += this.gameGrid.length;
                    } else if (x >= gameGrid.length) {
                        //else assign the value minus the length of the grid
                        x -= gameGrid.length;
                    }
                    if (y < 0) {
                        //if y less than 0, assign the value of the length of the row
                        y += this.gameGrid[row].length;
                    } else if (y + 1 > this.gameGrid[row].length) {
                        //else assign the value minus the length of the row
                        y -= y;
                    }
                    //if the particular cell has an x in one of the directions then count
                    if (this.gameGrid[x][y] == "x|") count++;

                }
                //add the neighbour found and reset the counter for new direction
                neighborsCount[row][col] = count;
                count = 0;
            }
    }

    void showGrid() {
       //method for grid reprint on new iteration
        for (int row = 0; row < this.gameGrid.length; row++) {
            for (int cell = 0; cell < this.gameGrid[row].length; cell++) {
                //Creation of life scenario
                if (this.gameGrid[row][cell] == " |" && this.neighborsCount[row][cell] == 3 ) {
                    this.gameGrid[row][cell] = "x|";
                    //Overcrowding scenario
                } else if (this.gameGrid[row][cell] == "x|" && this.neighborsCount[row][cell] > 3) {
                    this.gameGrid[row][cell] = " |";
                    // Underpopulation scenario
                } else if (this.gameGrid[row][cell] == "x|" && this.neighborsCount[row][cell] < 2) {
                    this.gameGrid[row][cell] = " |";
                    //No interactions scenario
                }else if(this.gameGrid[row][cell] == " |" && this.neighborsCount[row][cell] == 0){
                    this.gameGrid[row][cell] = " |";
                    //Survival scenario
                }else if(this.gameGrid[row][cell] == "x|" && this.neighborsCount[row][cell] == 2 || this.gameGrid[row][cell] == "x|" && this.neighborsCount[row][cell] == 3){
                    this.gameGrid[row][cell] = "x|";
                }
                System.out.print(this.gameGrid[row][cell]);
            }
            System.out.println();
        }
        System.out.println();
        //Begin check for neighbours after iteration
        this.checkNeighbors();
    }
}

