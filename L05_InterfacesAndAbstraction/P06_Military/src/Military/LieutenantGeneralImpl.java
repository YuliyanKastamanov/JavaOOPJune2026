package Military;

import java.util.ArrayList;
import java.util.Collection;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral{

    private Collection<Private> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary, Collection<Private> privates) {
        super(id, firstName, lastName, salary);
        setPrivates(privates);
    }

    public void setPrivates(Collection<Private> privates) {

        if(privates != null){
            this.privates = new ArrayList<>(privates);
            return;
        }
        this.privates = new ArrayList<>();
    }

    @Override
    public void addPrivate(Private priv) {
        this.privates.add(priv);

    }

    public Collection<Private> getPrivates() {
        return privates;
    }

    @Override
    public String toString() {


        //Name: {firstName} {lastName} Id: {id} Salary: {salary}
        //Privates:
        //  {private1 ToString()}
        //  {private2 ToString()}
        //  …
        //  {privateN ToString()}"

        //Name: {firstName} {lastName} Id: {id} Salary: {salary}
        StringBuilder builder = new StringBuilder(super.toString()).append(System.lineSeparator());
        builder.append("Privates:").append(System.lineSeparator());
        this.getPrivates().forEach(p -> builder.append("  ").append(p).append(System.lineSeparator()));
        return builder.toString();
    }
}
