public class Galaxy {

    private Field field;

    public Galaxy(Field field) {
        this.field = field;
    }

    public void moveEvil(int row, int col) {

        while (row >= 0 && col >= 0) {
            if (field.isInBounds(row, col)) {
                field.setValue(row, col, 0);
            }
            row--;
            col--;

        }
    }

    public long moveJedi(int jediRow, int jediCol) {

        long collectedPower = 0;

        while (jediRow >= 0 && jediCol < field.getColLength(1)) {
            if (field.isInBounds(jediRow, jediCol)) {
                collectedPower += field.getValue(jediRow, jediCol);
            }

            jediCol++;
            jediRow--;
        }

        return collectedPower;
    }
}
