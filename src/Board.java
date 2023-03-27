import javax.swing.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


public class Board {
    static Organism[][] field = new Organism[20][20];
    static int numOfRabbits;
    static int numOfFoxes;
    Random randomNumGen = new Random();

    static int rowScan = 0;
    static int colScan = 0;

    public Board() {
        numOfRabbits = 65;
        numOfFoxes = 7;
        initializeBoard(numOfRabbits, numOfFoxes);
    }

    public Board(int rabbits, int foxes) {
        numOfRabbits = rabbits;
        numOfFoxes = foxes;
        initializeBoard(numOfRabbits, numOfFoxes);
    }

    public void initializeBoard(int numRabbit, int numFox) {
        for (int i = 0; i < numRabbit; i++) {
            place(new Rabbit(), numRabbit);
        }
        for (int i = 0; i < numFox; i++) {
            place(new Fox(), numFox);
        }
    }

    public boolean isOccupied(int row, int col) {
        return Board.field[row][col] != null;
    }

    public void place(Organism o, int numOrganism) {
        int rowPos = randomNumGen.nextInt(20);
        int colPos = randomNumGen.nextInt(20);

        while (this.isOccupied(rowPos, colPos)) {
            rowPos = randomNumGen.nextInt(20);
            colPos = randomNumGen.nextInt(20);
        }

        if (o instanceof Rabbit) {
            Board.field[rowPos][colPos] = new Rabbit(rowPos, colPos);
        } else if (o instanceof Fox) {
            Board.field[rowPos][colPos] = new Fox(rowPos, colPos);
        } else {
            System.out.println("Error: in Board.place() Did not place a Animal in an open cell.");
            System.exit(0);
        }
    }
    public static Organism getOrganism(int row, int col) {
        return Board.field[row][col];
    }

    public static Organism getOrganism(int[] coords) {
        return Board.field[coords[0]][coords[1]];
    }

    public boolean rabbitNearby(Fox f)
    {
        if (f.topFlag && f.leftFlag) {
            return (getOrganism(f.getRowPos(), f.getColPos() + 1) instanceof Rabbit) ||
                    (getOrganism(f.getRowPos() + 1, f.getColPos()) instanceof Rabbit);
        }

        else if (f.bottomFlag && f.rightFlag) {
            return (getOrganism(f.getRowPos() - 1, f.getColPos()) instanceof Rabbit) ||
                    (getOrganism(f.getRowPos(), f.getColPos() - 1) instanceof Rabbit);
        }

        else if (f.topFlag && f.rightFlag) {
            return (getOrganism(f.getRowPos() + 1, f.getColPos()) instanceof Rabbit) ||
                    (getOrganism(f.getRowPos(), f.getColPos() - 1) instanceof Rabbit);
        }

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
    public static Integer[] randomDirections() {
        Integer[] directionArray = new Integer[] {1, 2, 3, 4};

        Collections.shuffle(Arrays.asList(directionArray));

        return directionArray;
    }
    /*
    public int getRabbitNumber(){
        return numOfRabbits;
    }
    public int getFoxNumber(){
        return numOfFoxes;
    }
    */
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
    public void starve(Fox f) {
        if (f.timeSinceLastMeal >= Fox.StarveTime) {
            this.removeAnimal(f.getRowPos(), f.getColPos());
        }
    }
}
