import javax.swing.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


// create a 20x20 grid of Organism objects
// track the number of rabbits and foxes on the board
// create a Random object to generate random numbers for placing the animals on the board
public class Board {
    static Organism[][] field = new Organism[20][20];
    static int numOfRabbits;
    static int numOfFoxes;
    Random randomNumGen = new Random();
    // flags to keep track of scanning positions
    static int rowScan = 0;
    static int colScan = 0;
    // constructor for a new Board with default number of rabbits and foxes
    public Board() {
        numOfRabbits = 65;
        numOfFoxes = 7;
        initializeBoard(numOfRabbits, numOfFoxes);
    }
    // constructor for a new Board with a specified number of rabbits and foxes
    public Board(int rabbits, int foxes) {
        numOfRabbits = rabbits;
        numOfFoxes = foxes;
        initializeBoard(numOfRabbits, numOfFoxes);
    }
    // initialize the board with the specified number of rabbits and foxes
    public void initializeBoard(int numRabbit, int numFox) {
        for (int i = 0; i < numRabbit; i++) {
            place(new Rabbit(), numRabbit);
        }
        for (int i = 0; i < numFox; i++) {
            place(new Fox(), numFox);
        }
    }
    // check if a cell on the board is occupied by an organism
    public boolean isOccupied(int row, int col) {
        return Board.field[row][col] != null;
    }

    // place an organism on a random unoccupied cell on the board
    // keep generating random positions until an unoccupied cell is found
    public void place(Organism o, int numOrganism) {
        int rowPos = randomNumGen.nextInt(20);
        int colPos = randomNumGen.nextInt(20);
        while (this.isOccupied(rowPos, colPos)) {
            rowPos = randomNumGen.nextInt(20);
            colPos = randomNumGen.nextInt(20);
        }
        // create a new Rabbit or Fox object and place it on the board
        if (o instanceof Rabbit) {
            Board.field[rowPos][colPos] = new Rabbit(rowPos, colPos);
        } else if (o instanceof Fox) {
            Board.field[rowPos][colPos] = new Fox(rowPos, colPos);
        } else {
            System.out.println("Error: in Board.place() Did not place a Animal in an open cell.");
            System.exit(0);
        }
    }
    // get the organism at a specific position on the board
    public static Organism getOrganism(int row, int col) {
        return Board.field[row][col];
    }
    // get the organism at a specific position on the board given an array of coordinates
    public static Organism getOrganism(int[] coords) {
        return Board.field[coords[0]][coords[1]];
    }
    // check if there is a rabbit nearby a fox
    public boolean rabbitNearby(Fox f) {
        // check if there is a rabbit to the left or above the fox
        if (f.topFlag && f.leftFlag) {
            return (getOrganism(f.getRowPos(), f.getColPos() + 1) instanceof Rabbit) ||
                    (getOrganism(f.getRowPos() + 1, f.getColPos()) instanceof Rabbit);
        }
        // check if there is a rabbit to the right or below the fox
        else if (f.bottomFlag && f.rightFlag) {
            return (getOrganism(f.getRowPos() - 1, f.getColPos()) instanceof Rabbit) ||
                    (getOrganism(f.getRowPos(), f.getColPos() - 1) instanceof Rabbit);
        }
        // check if there is a rabbit to the right or above the fox
        else if (f.topFlag && f.rightFlag) {
            return (getOrganism(f.getRowPos() + 1, f.getColPos()) instanceof Rabbit) ||
                    (getOrganism(f.getRowPos(), f.getColPos() - 1) instanceof Rabbit);
        }
        // check if there is a rabbit to the left or below the fox
        else if (f.bottomFlag && f.leftFlag) {
            return (getOrganism(f.getRowPos() - 1, f.getColPos()) instanceof Rabbit) ||
                    (getOrganism(f.getRowPos(), f.getColPos() + 1) instanceof Rabbit);
        }
        else if (f.topFlag) {
            return (getOrganism(f.getRowPos(), f.getColPos() + 1) instanceof Rabbit) ||
                    (getOrganism(f.getRowPos() + 1, f.getColPos()) instanceof Rabbit) ||
                    (getOrganism(f.getRowPos(), f.getColPos() - 1) instanceof Rabbit);
        }
        else if (f.rightFlag) {
            return (getOrganism(f.getRowPos() - 1, f.getColPos()) instanceof Rabbit) ||
                    (getOrganism(f.getRowPos() + 1, f.getColPos()) instanceof Rabbit) ||
                    (getOrganism(f.getRowPos(), f.getColPos() - 1) instanceof Rabbit);
        }
        else if (f.bottomFlag) {
            return (getOrganism(f.getRowPos() - 1, f.getColPos()) instanceof Rabbit) ||
                    (getOrganism(f.getRowPos(), f.getColPos() + 1) instanceof Rabbit) ||
                    (getOrganism(f.getRowPos(), f.getColPos() - 1) instanceof Rabbit);
        }
        else if (f.leftFlag) {
            return (getOrganism(f.getRowPos() - 1, f.getColPos()) instanceof Rabbit) ||
                    (getOrganism(f.getRowPos(), f.getColPos() + 1) instanceof Rabbit) ||
                    (getOrganism(f.getRowPos() + 1, f.getColPos()) instanceof Rabbit);
        }
        else return (getOrganism(f.getRowPos() - 1, f.getColPos()) instanceof Rabbit) ||
                    (getOrganism(f.getRowPos(), f.getColPos() + 1) instanceof Rabbit) ||
                    (getOrganism(f.getRowPos() + 1, f.getColPos()) instanceof Rabbit) ||
                    (getOrganism(f.getRowPos(), f.getColPos() - 1) instanceof Rabbit);
    }
    // check if there is an empty cell adjacent to an organism
    public boolean emptyCellAdj(Organism Animal) {
        if (Animal.topFlag && Animal.leftFlag) {
            return (getOrganism(Animal.getRowPos(), Animal.getColPos() + 1) == null) ||
                    (getOrganism(Animal.getRowPos() + 1, Animal.getColPos()) == null);
        }

        else if (Animal.bottomFlag && Animal.rightFlag) {
            return (getOrganism(Animal.getRowPos() - 1, Animal.getColPos()) == null) ||
                    (getOrganism(Animal.getRowPos(), Animal.getColPos() - 1) == null);
        }

        else if (Animal.topFlag && Animal.rightFlag) {
            return (getOrganism(Animal.getRowPos() + 1, Animal.getColPos()) == null) ||
                    (getOrganism(Animal.getRowPos(), Animal.getColPos() - 1) == null);
        }

        else if (Animal.bottomFlag && Animal.leftFlag) {
            return (getOrganism(Animal.getRowPos() - 1, Animal.getColPos()) == null) ||
                    (getOrganism(Animal.getRowPos(), Animal.getColPos() + 1) == null);
        }
        else if (Animal.topFlag) {
            return (getOrganism(Animal.getRowPos(), Animal.getColPos() + 1) == null) ||
                    (getOrganism(Animal.getRowPos() + 1, Animal.getColPos()) == null) ||
                    (getOrganism(Animal.getRowPos(), Animal.getColPos() - 1) == null);
        }

        else if (Animal.rightFlag) {
            return (getOrganism(Animal.getRowPos() - 1, Animal.getColPos()) == null) ||
                    (getOrganism(Animal.getRowPos() + 1, Animal.getColPos()) == null) ||
                    (getOrganism(Animal.getRowPos(), Animal.getColPos() - 1) == null);
        }

        else if (Animal.bottomFlag) {
            return (getOrganism(Animal.getRowPos() - 1, Animal.getColPos()) == null) ||
                    (getOrganism(Animal.getRowPos(), Animal.getColPos() + 1) == null) ||
                    (getOrganism(Animal.getRowPos(), Animal.getColPos() - 1) == null);
        }

        else if (Animal.leftFlag) {
            return (getOrganism(Animal.getRowPos() - 1, Animal.getColPos()) == null) ||
                    (getOrganism(Animal.getRowPos(), Animal.getColPos() + 1) == null) ||
                    (getOrganism(Animal.getRowPos() + 1, Animal.getColPos()) == null);
        }

        else return (getOrganism(Animal.getRowPos() - 1, Animal.getColPos()) == null) ||
                    (getOrganism(Animal.getRowPos(), Animal.getColPos() + 1) == null) ||
                    (getOrganism(Animal.getRowPos() + 1, Animal.getColPos()) == null) ||
                    (getOrganism(Animal.getRowPos(), Animal.getColPos() - 1) == null);
    }
    // print the board with the organisms
    public void printBoard() {

        JFrame frame = new JFrame();
        frame.setSize(750, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for(int i = 0; i < field.length; i++) {
            System.out.printf("%2d|", i);
            for(int j = 0; j < field[i].length; j++) {
                if (field[i][j] == null) {
                    System.out.print("-");
                }

                else {
                    System.out.print(field[i][j].symbol);
                }
            }
            System.out.print("|");
            if (i < field.length - 1) {
                System.out.println();
            }
        }
        System.out.println("\n");
        System.out.println("Number of Rabbits: " + numOfRabbits);
        System.out.println("Number of Foxes: " + numOfFoxes);
    }
    // This method removes an animal from the field, given its row and column position. It also checks the type of the animal and updates the number of rabbits or foxes accordingly.
    public void removeAnimal(int row, int col)
    {
        if (field[row][col] == null) {
            System.out.println("Error: in removeAnimal tried to remove a Animal, but there was none.");
            System.exit(0);
        }
        if(field[row][col] instanceof Rabbit) {
            numOfRabbits--;
        }
        if(field[row][col] instanceof Fox) {
            numOfFoxes--;
        }
        field[row][col] = null;
    }
    // This method returns an array of integers representing random directions.
    public static Integer[] randomDirections() {
        Integer[] directionArray = new Integer[] {1, 2, 3, 4};

        Collections.shuffle(Arrays.asList(directionArray));

        return directionArray;
    }
    // These two methods return the number of rabbits or foxes on the field.
    public int getRabbitNumber(){
        return numOfRabbits;
    }
    public int getFoxNumber(){
        return numOfFoxes;
    }
    // This method scans the field for rabbits and returns their coordinates as an array of integers.
    public static int[] rabbitScanner() {
        for (int j = colScan; j < 20; j++) {
            if (field[rowScan][j] instanceof Rabbit) {
                if (colScan == 19) {
                    colScan = 0;
                    rowScan++;
                    return new int[] {rowScan - 1, 19};
                }

                else {
                    colScan = j + 1;
                    return new int[] {rowScan, j};
                }
            }
        }
        rowScan++;
        colScan = 0;
        for (int i = rowScan; i < 20; i++) {
            for (int j = colScan; j < 20; j++) {
                if (field[i][j] instanceof Rabbit) {
                    if (j == 19) {
                        rowScan++;
                        return new int[] {i, 19};
                    }
                    else {
                        colScan = j + 1;
                        return new int[] {i, j};
                    }
                }

                else if (j == 19) {
                    rowScan++;
                }
            }
        }
        rowScan = 0;
        return new int[] {-1, -1};
    }
    // This method scans the field for foxes and returns their coordinates as an array of integers.
    public static int[] foxScanner() {
        for (int j = colScan; j < 20; j++) {
            if (field[rowScan][j] instanceof Fox) {
                if (colScan == 19) {
                    colScan = 0;
                    rowScan++;
                    return new int[] {rowScan - 1, 19};
                }
                else {
                    colScan = j + 1;
                    return new int[] {rowScan, j};
                }
            }
        }
        rowScan++;
        colScan = 0;
        for (int i = rowScan; i < 20; i++) {
            for (int j = colScan; j < 20; j++) {
                if (field[i][j] instanceof Fox) {
                    if (j == 19) {
                        rowScan++;
                        return new int[] {i, 19};
                    }

                    else {
                        colScan = j + 1;
                        return new int[] {i, j};
                    }
                }
            }
            rowScan++;
        }
        rowScan = 0;
        return new int[] {-1, -1};
    }
    public static void moveAnimal(Organism Animal, int dir)
    {
        int rowPos = Animal.getRowPos();
        int colPos = Animal.getColPos();

        if (Animal.getSymbol() == 'R')
        {
            switch (dir) {
                case 1 -> {
                    field[rowPos - 1][colPos] = new Rabbit((Rabbit) Animal);
                    getOrganism(rowPos - 1, colPos).setRowPos(rowPos - 1);
                    field[rowPos][colPos] = null;
                    rowPos--;
                }
                case 2 -> {
                    field[rowPos][colPos + 1] = new Rabbit((Rabbit) Animal);
                    getOrganism(rowPos, colPos + 1).setColPos(colPos + 1);
                    field[rowPos][colPos] = null;
                    colPos++;
                }
                case 3 -> {
                    field[rowPos + 1][colPos] = new Rabbit((Rabbit) Animal);
                    getOrganism(rowPos + 1, colPos).setRowPos(rowPos + 1);
                    field[rowPos][colPos] = null;
                    rowPos++;
                }
                case 4 -> {
                    field[rowPos][colPos - 1] = new Rabbit((Rabbit) Animal);
                    getOrganism(rowPos, colPos - 1).setColPos(colPos - 1);
                    field[rowPos][colPos] = null;
                    colPos--;
                }
            }
        } else if(Animal.getSymbol() == 'F') {
            switch (dir) {
                case 1 -> {
                    field[rowPos - 1][colPos] = new Fox((Fox) Animal);
                    getOrganism(rowPos - 1, colPos).setRowPos(rowPos - 1);
                    field[rowPos][colPos] = null;
                    rowPos--;
                }
                case 2 -> {
                    field[rowPos][colPos + 1] = new Fox((Fox) Animal);
                    getOrganism(rowPos, colPos + 1).setColPos(colPos + 1);
                    field[rowPos][colPos] = null;
                    colPos++;
                }
                case 3 -> {
                    field[rowPos + 1][colPos] = new Fox((Fox) Animal);
                    getOrganism(rowPos + 1, colPos).setRowPos(rowPos + 1);
                    field[rowPos][colPos] = null;
                    rowPos++;
                }
                case 4 -> {
                    field[rowPos][colPos - 1] = new Fox((Fox) Animal);
                    getOrganism(rowPos, colPos - 1).setColPos(colPos - 1);
                    field[rowPos][colPos] = null;
                    colPos--;
                }
            }
            Animal.timeSinceBreed++;
        }
    }
    // This method checks if an animal can breed and if there is an empty cell adjacent to it.
    public void breed(Organism Animal)
    {
        if ((Animal.timeSinceBreed == Animal.breedTime) && this.emptyCellAdj(Animal)) {
            int row = Animal.getRowPos();
            int col = Animal.getColPos();
            Integer[] randomDirections = Board.randomDirections();
            boolean breedComplete = false;

            if (Animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) Board.getOrganism(row, col);
                for (int i = 0; i < 4 && (!breedComplete); i++) {
                    switch (randomDirections[i]) {
                        case 1 -> {
                            if (rabbit.topFlag)
                                break;
                            if (Board.getOrganism(row - 1, col) == null) {
                                field[row - 1][col] = new Rabbit(row - 1, col);
                                breedComplete = true;
                            }
                        }
                        case 2 -> {
                            if (rabbit.rightFlag)
                                break;
                            if (Board.getOrganism(row, col + 1) == null) {
                                field[row][col + 1] = new Rabbit(row, col + 1);
                                breedComplete = true;
                            }
                        }
                        case 3 -> {
                            if (rabbit.bottomFlag)
                                break;
                            if (Board.getOrganism(row + 1, col) == null) {
                                field[row + 1][col] = new Rabbit(row + 1, col);
                                breedComplete = true;
                            }
                        }
                        case 4 -> {
                            if (rabbit.leftFlag)
                                break;
                            if (Board.getOrganism(row, col - 1) == null) {
                                field[row][col - 1] = new Rabbit(row, col - 1);
                                breedComplete = true;
                            }
                        }
                    }
                }
                Animal.timeSinceBreed = 0;
                numOfRabbits++;
            }
            else if (Animal instanceof Fox)
            {
                Fox f = (Fox) Board.getOrganism(row, col);

                for (int i = 0; i < 4 && (!breedComplete); i++)
                {
                    switch (randomDirections[i]) {
                        case 1 -> {
                            if (f.topFlag)
                                break;
                            if (Board.getOrganism(row - 1, col) == null) {
                                field[row - 1][col] = new Fox(row - 1, col);
                                breedComplete = true;
                            }
                        }
                        case 2 -> {
                            if (f.rightFlag)
                                break;
                            if (Board.getOrganism(row, col + 1) == null) {
                                field[row][col + 1] = new Fox(row, col + 1);
                                breedComplete = true;
                            }
                        }
                        case 3 -> {
                            if (f.bottomFlag)
                                break;
                            if (Board.getOrganism(row + 1, col) == null) {
                                field[row + 1][col] = new Fox(row + 1, col);
                                breedComplete = true;
                            }
                        }
                        case 4 -> {
                            if (f.leftFlag)
                                break;
                            if (Board.getOrganism(row, col - 1) == null) {
                                field[row][col - 1] = new Fox(row, col - 1);
                                breedComplete = true;
                            }
                        }
                    }
                }
                Animal.timeSinceBreed = 0;
                numOfFoxes++;
            }
            else {
                System.out.println("Error breeding!");
                System.exit(0);
            }
        }
    }
    // This method checks if a fox has not eaten for a certain amount of time and if so, it removes the fox from the board.
    public void starve(Fox f) {
        if (f.timeSinceLastMeal >= Fox.StarveTime) {
            this.removeAnimal(f.getRowPos(), f.getColPos());
        }
    }
}
