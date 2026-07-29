package Military;

import java.util.ArrayList;
import java.util.Collection;

public class EngineerImpl extends SpecialisedSoldierImpl  implements Engineer {

    private Collection<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, String corps, Collection<Repair> repairs) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = repairs;
    }

    public void setRepairs(Collection<Repair> repairs) {

        if(repairs != null){
            this.repairs = new ArrayList<>(repairs);
            return;
        }
        this.repairs = new ArrayList<>();
    }

    @Override
    public void addRepair(Repair repair) {

        this.repairs.add(repair);

    }

    @Override
    public Collection<Repair> getRepairs() {
        return this.repairs;
    }

    @Override
    public String toString() {

        //Engineer:
        //"Name: {firstName} {lastName} Id: {id} Salary: {salary}
        //Corps: {corps}
        //Repairs:
        //  {repair1 ToString()}
        //  {repair2 ToString()}
        //  …
        //  {repairN ToString()}"
        StringBuilder builder = new StringBuilder();
        builder.append("Engineer:").append(System.lineSeparator());
        builder.append(super.toString()).append(System.lineSeparator());
        this.getRepairs().forEach(repair -> builder.append("  ").append(repair).append(System.lineSeparator()));
        return builder.toString();
    }
}
