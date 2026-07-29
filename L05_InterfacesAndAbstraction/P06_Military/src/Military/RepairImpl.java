package Military;

public class RepairImpl implements Repair {


    private String partName;
    private int hours;

    public RepairImpl(String partName, int hours) {
        this.partName = partName;
        this.hours = hours;
    }

    @Override
    public String getPartName() {
        return partName;
    }

    @Override
    public int getHours() {
        return hours;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d", this.getPartName(), this.getHours());
    }
}
