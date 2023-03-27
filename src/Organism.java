public class Organism {
    int breedTime;
    int timeSinceBreed;
    char symbol; // 'R' for rabbit, 'F' for fox
    int rowPos;
    int colPos;

    // Flags for edge of the Board
    boolean topFlag;
    boolean bottomFlag;
    boolean leftFlag;
    boolean rightFlag;

    public Organism() {
        this.setRowPos(-1);
        this.setColPos(-1);
        this.timeSinceBreed = 0;
        this.topFlag = true;
        this.bottomFlag = true;
        this.leftFlag = true;
        this.rightFlag = true;
    }

    public Organism(int rowPos, int colPos) {
        this.setRowPos(rowPos);
        this.setColPos(colPos);
        this.timeSinceBreed = 0;
    }

    public Organism(Organism o) {
        this.symbol = o.symbol;
        this.setRowPos(o.getRowPos());
        this.setColPos(o.getColPos());
        this.breedTime = o.breedTime;
        this.timeSinceBreed = o.timeSinceBreed;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public int getRowPos() {
        return this.rowPos;
    }

    public int getColPos() {
        return this.colPos;
    }

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
