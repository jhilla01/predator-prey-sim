// Organism class represents an organism in the simulation, which can be either a Rabbit or a Fox.
public class Organism {
    int breedTime; // the time it takes for the organism to breed
    int timeSinceBreed; // the time that has passed since the organism last bred
    char symbol; // 'R' for rabbit, 'F' for fox
    int rowPos; // the row position of the organism on the board
    int colPos; // the column position of the organism on the board

    // Flags for edge of the Board
    boolean topFlag; // true if the organism is at the top of the board
    boolean bottomFlag; // true if the organism is at the bottom of the board
    boolean leftFlag; // true if the organism is at the left of the board
    boolean rightFlag; // true if the organism is at the right of the board

    // Constructs an organism object with default values
    public Organism() {
        this.setRowPos(-1);
        this.setColPos(-1);
        this.timeSinceBreed = 0;
        this.topFlag = true;
        this.bottomFlag = true;
        this.leftFlag = true;
        this.rightFlag = true;
    }
    // Constructs an organism object with a given row and column position
    public Organism(int rowPos, int colPos) {
        this.setRowPos(rowPos);
        this.setColPos(colPos);
        this.timeSinceBreed = 0;
    }
    // Constructs an organism object with the same attributes as another organism object
    public Organism(Organism o) {
        this.symbol = o.symbol;
        this.setRowPos(o.getRowPos());
        this.setColPos(o.getColPos());
        this.breedTime = o.breedTime;
        this.timeSinceBreed = o.timeSinceBreed;
    }
    // Returns the symbol of the organism ('R' for rabbit and 'F' for fox)
    public char getSymbol() {
        return this.symbol;
    }

    public int getRowPos() {
        return this.rowPos;
    }

    public int getColPos() {
        return this.colPos;
    }
    // Sets the row position of the organism on the board
    public void setRowPos(int row) {
        this.topFlag = false;
        this.bottomFlag = false;
        this.rowPos = row;
        if (row <= 0) {
            this.topFlag = true;
        } else if (row >= Board.field.length - 1) {
            this.bottomFlag = true;
        }
    }
    // Sets the column position of the organism on the board
        public void setColPos(int col) {
            this.leftFlag = false;
            this.rightFlag = false;
            this.colPos = col;
            if (col <= 0) {
                this.leftFlag = true;
            } else if (col >= Board.field[0].length - 1) {
                this.rightFlag = true;
            }
        }
    }
