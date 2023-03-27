import javax.swing.*;
import java.util.ArrayList;


public class Simulator {
    static ArrayList<Integer> rabbitCount = new ArrayList<Integer>();
    static ArrayList<Integer> foxCount = new ArrayList<Integer>();

    public static void eatRabbit(int[] coordinates) {

        Fox f = (Fox) Board.getOrganism(coordinates[0], coordinates[1]);

        Integer[] randomDirections = Board.randomDirections();

        boolean moveComplete = false;

        for (int i = 0; i < 4 && (!moveComplete); i++) {
            switch (randomDirections[i]) {
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
        int[][] positions = new int[Board.numOfRabbits][2];

        for (int i = 0; i < Board.numOfRabbits; i++) {
            positions[i] = Board.rabbitScanner();
        }
        Board.rowScan = 0;
        Board.colScan = 0;
        return positions;
    }

    public static int[][] FoxPositions() {
        int[][] positions = new int[Board.numOfFoxes][2];

        for (int i = 0; i < Board.numOfFoxes; i++) {
            positions[i] = Board.foxScanner();
        }
        Board.rowScan = 0;
        Board.colScan = 0;
        return positions;
    }

    public static void turnSequence(Board testBoard) {
        int[][] fPositions = new int[Board.numOfFoxes][2];
        fPositions = FoxPositions();
        int[] position = new int[2];

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

            if (testBoard.rabbitNearby((Fox)Board.getOrganism(position))) {
                Fox f = (Fox)Board.getOrganism(position);
                f.timeSinceLastMeal = 0;
                f.timeSinceBreed++;
                eatRabbit(position);

            }
            else {
                Fox f = (Fox)Board.getOrganism(position);
                f.timeSinceLastMeal++;
                f.timeSinceBreed++;
                moveFox(position);
            }
        }

        int[][] RabbitPositions = new int[Board.numOfRabbits][2];
        RabbitPositions = RabbitPositions();

        for (int i = 0; i < Board.numOfRabbits; i++) {
            position = RabbitPositions[i];

            if (position[0] < 0 || position[1] < 0) {
                break;
            }
            Rabbit Rabbit = (Rabbit)Board.getOrganism(position);
            Rabbit.timeSinceBreed++;
            moveRabbit(position);
        }
        Board.rowScan = 0;
        Board.colScan = 0;

        fPositions = FoxPositions();
        int tempNumberOfFoxs = Board.numOfFoxes;
        for (int i = 0; i < tempNumberOfFoxs; i++) {
            position = fPositions[i];
            int row = position[0];
            int col = position[1];

            if (row < 0 || col < 0) {
                break;
            }
            testBoard.breed(Board.getOrganism(position));
        }

        RabbitPositions = RabbitPositions();
        int tempNumberOfRabbits = Board.numOfRabbits;
        for (int i = 0; i < tempNumberOfRabbits; i++) {
            position = RabbitPositions[i];
            int row = position[0];
            int col = position[1];

            if (row < 0 || col < 0) {
                break;
            }
            testBoard.breed(Board.getOrganism(row, col));
        }

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
