public class Rabbit extends Organism {
    public Rabbit() {
        super();
        this.symbol = 'R';
        this.breedTime = 2;
    }
    public Rabbit(int rowPos, int colPos) {
        super(rowPos, colPos);
        this.symbol = 'R';
        this.breedTime = 2;
    }

    public Rabbit(Rabbit f) {
        super(f);
    }

    //Move method for Rabbit
    public void moveRabbit(int dir) {
        if (dir < 1 || dir > 4) {
            System.out.println("Invalid direction/Input Parameter");
            System.exit(0);
        }
        switch (dir) {
            case 1 -> {
                Board.field[this.getRowPos() - 1][this.getColPos()] = this;
                Board.field[this.getRowPos()][this.getColPos()] = null;
                this.setRowPos(this.getRowPos() - 1);
            }
            case 2 -> {
                Board.field[this.getRowPos()][this.getColPos() + 1] = this;
                Board.field[this.getRowPos()][this.getColPos()] = null;
                this.setColPos(this.getColPos() + 1);
            }
            case 3 -> {
                Board.field[this.getRowPos() + 1][this.getColPos()] = this;
                Board.field[this.getRowPos()][this.getColPos()] = null;
                this.setRowPos(this.getRowPos() + 1);
            }
            case 4 -> {
                Board.field[this.getRowPos()][this.getColPos() - 1] = this;
                Board.field[this.getRowPos()][this.getColPos()] = null;
                this.setColPos(this.getColPos() - 1);
            }
        }
    }

}
