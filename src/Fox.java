public class Fox extends Organism {
    final static int StarveTime = 2;
    int timeSinceLastMeal;
    public Fox() {
        super();
        this.symbol = 'F';
        this.breedTime = 7;
        this.timeSinceLastMeal = 0;
    }
    public Fox(int rowPos, int colPos) {
        super(rowPos, colPos);
        this.symbol = 'F';
        this.breedTime = 7;
        this.timeSinceLastMeal = 0;
    }

    public Fox(Fox f) {
        super(f);
        this.symbol = f.symbol;
        this.breedTime = f.breedTime;
        this.timeSinceLastMeal = f.timeSinceLastMeal;
    }
    //Move method for Fox
    public void moveFox(int dir) {
        // Check if the given direction is valid
        if (dir < 1 || dir > 4) {
            System.out.println("Invalid direction/Input Parameter");
            System.exit(0);
        }
        // Move the fox to the new position based on the given direction
        switch (dir) {
            case 1 -> {
                Board.field[this.getRowPos() - 1][this.getColPos()] = null;
                Board.field[this.getRowPos() - 1][this.getColPos()] = this;
                Board.field[this.getRowPos()][this.getColPos()] = null;
                this.setRowPos(this.getRowPos() - 1);
            }
            case 2 -> {
                Board.field[this.getRowPos()][this.getColPos() + 1] = null;
                Board.field[this.getRowPos()][this.getColPos() + 1] = this;
                Board.field[this.getRowPos()][this.getColPos()] = null;
                this.setColPos(this.getColPos() + 1);
            }
            case 3 -> {
                Board.field[this.getRowPos() + 1][this.getColPos()] = null;
                Board.field[this.getRowPos() + 1][this.getColPos()] = this;
                Board.field[this.getRowPos()][this.getColPos()] = null;
                this.setRowPos(this.getRowPos() + 1);
            }
            case 4 -> {
                Board.field[this.getRowPos()][this.getColPos() - 1] = null;
                Board.field[this.getRowPos()][this.getColPos() - 1] = this;
                Board.field[this.getRowPos()][this.getColPos()] = null;
                this.setColPos(this.getColPos() - 1);
            }
        }

    }
}
