import javax.swing.*;
import java.util.ArrayList;


public class Simulator {
    static ArrayList<Integer> rabbitCount = new ArrayList<Integer>();
    static ArrayList<Integer> foxCount = new ArrayList<Integer>();

    public static void eatRabbit(int[] coordinates) {
        // Get the fox at the given coordinates
        Fox f = (Fox) Board.getOrganism(coordinates[0], coordinates[1]);
        // Generate random directions for the fox to move in
        Integer[] randomDirections = Board.randomDirections();
        // Initialize a boolean flag to check whether the fox has completed its move
        boolean moveComplete = false;
        // Iterate over the possible move directions until a move is completed or all directions are exhausted
        for (int i = 0; i < 4 && (!moveComplete); i++) {
            // Check the direction indicated by the current value of the randomDirections array
            switch (randomDirections[i]) {
                // Move up
                // Check if the fox has already moved up in this turn
                // Check if there is a rabbit at the position above the fox
                // If a rabbit is found, remove it from the board and move the fox up to the empty space
                // Decrement the count of rabbits on the board
                // Set the moveComplete flag to true to exit the loop
                case 1 -> {
                    if (f.topFlag)
                        break;
                    if (Board.getOrganism(coordinates[0] - 1, coordinates[1]) instanceof Rabbit) {
                        Board.field[coordinates[0] - 1][coordinates[1]] = null;
                        Board.moveAnimal(Board.getOrganism(coordinates[0], coordinates[1]), 1);
                        moveComplete = true;
                        Board.numOfRabbits--;
                    }
                }
                // Move right
                // Check if the fox has already moved right in this turn
                // Check if there is a rabbit at the position to the right of the fox
                // If a rabbit is found, remove it from the board and move the fox right to the empty space
                // Decrement the count of rabbits on the board
                // Set the moveComplete flag to true to exit the loop
                case 2 -> {
                    if (f.rightFlag)
                        break;
                    if (Board.getOrganism(coordinates[0], coordinates[1] + 1) instanceof Rabbit) {
                        Board.field[coordinates[0]][coordinates[1] + 1] = null;
                        Board.moveAnimal(Board.getOrganism(coordinates[0], coordinates[1]), 2);
                        moveComplete = true;
                        Board.numOfRabbits--;
                    }
                }
                // Move down
                // Check if the fox has already moved down in this turn
                // Check if there is a rabbit at the position below the fox
                // If a rabbit is found, remove it from the board and move the fox down to the empty space
                // Decrement the count of rabbits on the board
                // Set the moveComplete flag to true to exit the loop
                case 3 -> {
                    if (f.bottomFlag)
                        break;
                    if (Board.getOrganism(coordinates[0] + 1, coordinates[1]) instanceof Rabbit) {
                        Board.field[coordinates[0] + 1][coordinates[1]] = null;
                        Board.moveAnimal(Board.getOrganism(coordinates[0], coordinates[1]), 3);
                        moveComplete = true;
                        Board.numOfRabbits--;
                    }
                }
                // Move left
                // Check if the fox has already moved left in this turn
                // Check if there is a rabbit at the position to the left of the fox
                // If a rabbit is found, remove it from the board and move the fox left to the empty space
                // Decrement the count of rabbits on the board
                // Set the moveComplete flag to true to exit the loop
                case 4 -> {
                    if (f.leftFlag)
                        break;
                    if (Board.getOrganism(coordinates[0], coordinates[1] - 1) instanceof Rabbit) {
                        Board.field[coordinates[0]][coordinates[1] - 1] = null;
                        Board.moveAnimal(Board.getOrganism(coordinates[0], coordinates[1]), 4);
                        moveComplete = true;
                        Board.numOfRabbits--;
                    }
                }
            }
        }

    }

    public static void moveFox(int[] coordinates)
    {
        int row = coordinates[0];
        int col = coordinates[1];
        Fox f = (Fox) Board.getOrganism(row, col);

        Integer[] randomDirections = Board.randomDirections();
        boolean moveComplete = false;
        for (int i = 0; i < 4 && (!moveComplete); i++)
        {
            switch (randomDirections[i]) {
                case 1 -> {
                    if (f.topFlag)
                        break;
                    if (Board.getOrganism(coordinates[0] - 1, coordinates[1]) == null) {
                        Board.moveAnimal(Board.getOrganism(coordinates[0], coordinates[1]), 1);
                        moveComplete = true;
                    }
                }
                case 2 -> {
                    if (f.rightFlag)
                        break;
                    if (Board.getOrganism(coordinates[0], coordinates[1] + 1) == null) {
                        Board.moveAnimal(Board.getOrganism(coordinates[0], coordinates[1]), 2);
                        moveComplete = true;
                    }
                }
                case 3 -> {
                    if (f.bottomFlag)
                        break;
                    if (Board.getOrganism(coordinates[0] + 1, coordinates[1]) == null) {
                        Board.moveAnimal(Board.getOrganism(coordinates[0], coordinates[1]), 3);
                        moveComplete = true;
                    }
                }
                case 4 -> {
                    if (f.leftFlag)
                        break;
                    if (Board.getOrganism(coordinates[0], coordinates[1] - 1) == null) {
                        Board.moveAnimal(Board.getOrganism(coordinates[0], coordinates[1]), 4);
                        moveComplete = true;
                    }
                }
            }
        }
    }

    public static void moveRabbit(int[] coordinates) {
        int row = coordinates[0];
        int col = coordinates[1];

        Rabbit Rabbit = (Rabbit) Board.getOrganism(row, col);

        Integer[] randomDirections = Board.randomDirections();
        boolean moveComplete = false;

        for (int i = 0; i < 4 && (!moveComplete); i++) {
            switch (randomDirections[i]) {
                case 1 -> {
                    if (Rabbit.topFlag)
                        break;
                    if (Board.getOrganism(coordinates[0] - 1, coordinates[1]) == null) {
                        Board.moveAnimal(Board.getOrganism(coordinates[0], coordinates[1]), 1);
                        moveComplete = true;
                    }
                }
                case 2 -> {
                    if (Rabbit.rightFlag)
                        break;
                    if (Board.getOrganism(coordinates[0], coordinates[1] + 1) == null) {
                        Board.moveAnimal(Board.getOrganism(coordinates[0], coordinates[1]), 2);
                        moveComplete = true;
                    }
                }
                case 3 -> {
                    if (Rabbit.bottomFlag)
                        break;
                    if (Board.getOrganism(coordinates[0] + 1, coordinates[1]) == null) {
                        Board.moveAnimal(Board.getOrganism(coordinates[0], coordinates[1]), 3);
                        moveComplete = true;
                    }
                }
                case 4 -> {
                    if (Rabbit.leftFlag)
                        break;
                    if (Board.getOrganism(coordinates[0], coordinates[1] - 1) == null) {
                        Board.moveAnimal(Board.getOrganism(coordinates[0], coordinates[1]), 4);
                        moveComplete = true;
                    }
                }
            }
        }
    }

    public static int[][] RabbitPositions() {
        // Create 2D array of rabbit positions
        int[][] positions = new int[Board.numOfRabbits][2];
        // Store each rabbit position in the array
        for (int i = 0; i < Board.numOfRabbits; i++) {
            positions[i] = Board.rabbitScanner();
        }
        // Reset the scanner row to 0
        // Reset the scanner column to 0
        // Return the array of rabbit positions
        Board.rowScan = 0;
        Board.colScan = 0;
        return positions;
    }

    public static int[][] FoxPositions() {
        // Create 2D array of fox positions
        int[][] positions = new int[Board.numOfFoxes][2];
        // Store each fox position in the array
        for (int i = 0; i < Board.numOfFoxes; i++) {
            positions[i] = Board.foxScanner();
        }
        // Reset the scanner row to 0
        // Reset the scanner column to 0
        // Return the array of fox positions
        Board.rowScan = 0;
        Board.colScan = 0;
        return positions;
    }

    public static void turnSequence(Board testBoard) {
        // Get array of fox positions
        int[][] fPositions = new int[Board.numOfFoxes][2];
        fPositions = FoxPositions();
        int[] position = new int[2];
        // Get the next fox position in the array
        for (int i = 0; i < Board.numOfFoxes; i++) {
            position = fPositions[i];

            if (position[0] < 0 || position[1] < 0) {
                System.out.println("-1 from FoxScanner");
                System.exit(0);
            }
            else if (position[0] > 19 || position[1] > 19) {
                System.out.println("20 from FoxScanner");
                System.exit(0);
            }
            // If there is a nearby rabbit
            // Get the fox object at the position
            // Reset the time since last meal
            // Increment the time since breed
            // Eat the rabbit with eatRabbit method
            if (testBoard.rabbitNearby((Fox)Board.getOrganism(position))) {
                Fox f = (Fox)Board.getOrganism(position);
                f.timeSinceLastMeal = 0;
                f.timeSinceBreed++;
                eatRabbit(position);

            }
            // If there is no nearby rabbit
            // Get the fox object at the position
            // Increment the time since last meal
            // Increment the time since breed
            // Move the fox with moveFox method
            else {
                Fox f = (Fox)Board.getOrganism(position);
                f.timeSinceLastMeal++;
                f.timeSinceBreed++;
                moveFox(position);
            }
        }
        // Get array of rabbit positions
        int[][] RabbitPositions = new int[Board.numOfRabbits][2];
        RabbitPositions = RabbitPositions();
        // Get the next rabbit position in the array
        for (int i = 0; i < Board.numOfRabbits; i++) {
            position = RabbitPositions[i];
            if (position[0] < 0 || position[1] < 0) {
                break;
            }
            // Get the rabbit object at the position
            // Increment the time since breed
            // Move the rabbit with moveRabbit method
            Rabbit Rabbit = (Rabbit)Board.getOrganism(position);
            Rabbit.timeSinceBreed++;
            moveRabbit(position);
        }
        Board.rowScan = 0;
        Board.colScan = 0;
        // Get the positions of all the foxes on the board and iterate through each fox to check if they can breed
        fPositions = FoxPositions();
        int tempNumberOfFoxs = Board.numOfFoxes;
        for (int i = 0; i < tempNumberOfFoxs; i++) {
            position = fPositions[i];
            int row = position[0];
            int col = position[1];

            if (row < 0 || col < 0) {
                break;
            }
            // Check if the fox can breed and breed if it can
            testBoard.breed(Board.getOrganism(position));
        }
        // Get the positions of all the rabbits on the board and iterate through each rabbit to check if they can breed
        RabbitPositions = RabbitPositions();
        int tempNumberOfRabbits = Board.numOfRabbits;
        for (int i = 0; i < tempNumberOfRabbits; i++) {
            position = RabbitPositions[i];
            int row = position[0];
            int col = position[1];

            if (row < 0 || col < 0) {
                break;
            }
            // Check if the rabbit can breed and breed if it can
            testBoard.breed(Board.getOrganism(row, col));
        }
        // Get the positions of all the foxes on the board and iterate through each fox to check if it can starve and remove it from the board if it can
        fPositions = FoxPositions();
        tempNumberOfFoxs = Board.numOfFoxes;
        for (int i = 0; i < tempNumberOfFoxs; i++) {
            testBoard.starve((Fox)Board.getOrganism(fPositions[i][0], fPositions[i][1]));
        }
    }
    public static void main(String[] args) {
        Board testBoard = new Board();
        testBoard.printBoard();
        int i = 0;
        // While there are still rabbits or foxes on the board and i is less than 300
        // Add the number of rabbits and foxes to the array lists
        // Call the turnSequence method on the testBoard instance to advance the simulation by one turn
        // Print the board
        while ((Board.numOfRabbits != 0 || Board.numOfFoxes != 0) && i < 300) {
            rabbitCount.add(Board.numOfRabbits);
            foxCount.add(Board.numOfFoxes);
            turnSequence(testBoard);
            testBoard.printBoard();
            i++;
        }


        Graph g = new Graph(rabbitCount, foxCount);
        JFrame frame = new JFrame();
        frame.add(g);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 1500);
        frame.setVisible(true);
    }
}
