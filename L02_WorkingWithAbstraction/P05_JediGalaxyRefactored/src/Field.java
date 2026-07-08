public class Field {

    private int[][] matrix;

    public Field(int rows, int cows) {
        this(rows, cows, 0);
    }

    public Field(int rows, int cows, int beginValue) {
        this.matrix = new int[rows][cows];
        this.fillMatrix(beginValue);
    }

    private void fillMatrix(int beginValue) {

        for (int row = 0; row < this.matrix.length; row++) {
            for (int col = 0; col < this.matrix[row].length; col++) {
                matrix[row][col] = beginValue++;
            }
        }
    }

    public boolean isInBounds(int row, int cow){

        return row >= 0 && row < this.matrix.length && cow >= 0 && cow < matrix[row].length;
    }


    public void setValue(int row, int col, int newValue){
        this.matrix[row][col] = newValue;
    }

    public int getColLength(int row){
        return this.matrix[row].length;
    }

    public int getValue(int row, int col){
        return this.matrix[row][col];
    }


}
