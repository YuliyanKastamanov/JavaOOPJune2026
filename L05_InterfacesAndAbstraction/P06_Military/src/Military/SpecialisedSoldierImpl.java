package Military;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {

    private Corps corps;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        setCorps(corps);
    }

    public void setCorps(String corps) {
        if(corps.equals("Airforces") || corps.equals("Marines")){
            this.corps = Corps.valueOf(corps);
        }
    }

    @Override
    public String getCorps() {
        return corps.name();
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append(super.toString()).append(System.lineSeparator());
        builder.append(String.format("Corps: %s", this.getCorps()));
        return builder.toString();
    }
}
